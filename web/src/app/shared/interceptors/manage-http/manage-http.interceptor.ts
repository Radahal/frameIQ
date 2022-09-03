import {Injectable} from "@angular/core";
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {ActivationEnd, Router} from "@angular/router";
import {filter, Observable, takeUntil} from "rxjs";
import {RequestCancellationService} from "../../services/request-cancellation/request-cancellation.service";

@Injectable()
export class ManageHttpInterceptor implements HttpInterceptor {
  constructor(
    private router: Router,
    private requestCancellationService: RequestCancellationService,
  ) {
    router.events.subscribe((event) => {
      if (event instanceof ActivationEnd) {
        requestCancellationService.cancelPendingRequests();
      }
    })
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next
      .handle(request)
      .pipe(
        takeUntil(
          this.requestCancellationService.onCancelPendingRequests$.pipe(
            filter(() => request.method === 'GET' && request.url.includes("api")),
          )
        )
      )
  }
}

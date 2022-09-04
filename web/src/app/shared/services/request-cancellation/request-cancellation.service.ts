import {Injectable} from "@angular/core";
import {Observable, Subject} from "rxjs";

@Injectable({
  providedIn: "root"
})
export class RequestCancellationService {
  private pendingHttpRequests$ = new Subject<void>();

  constructor() {
  }

  cancelPendingRequests() {
    this.pendingHttpRequests$.next(void 0);
  }

  get onCancelPendingRequests$(): Observable<void> {
    return this.pendingHttpRequests$.asObservable();
  }
}

import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {ToastrModule} from "ngx-toastr";
import {ManageHttpInterceptor} from "./shared/interceptors/manage-http/manage-http.interceptor";
import {TranslocoRootModule} from "./transloco/transloco-root.module";
import {ToastrCustomComponent} from "./shared/components/toastr-custom/toastr-custom.component";
import {HeaderModule} from "./header/header.module";

@NgModule({
  declarations: [
    AppComponent,
    ToastrCustomComponent
  ],
    imports: [
      BrowserModule,
      AppRoutingModule,
      HttpClientModule,
      BrowserAnimationsModule,
      HeaderModule,
      TranslocoRootModule,
      ToastrModule.forRoot({
        timeOut: 10000,
        preventDuplicates: true,
        resetTimeoutOnDuplicate: true,
        positionClass: "toast-position-bottom-top",
        toastComponent: ToastrCustomComponent
      })
    ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: ManageHttpInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }

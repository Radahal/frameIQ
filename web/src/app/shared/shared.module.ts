import {Injector, NgModule, Optional, SkipSelf} from "@angular/core";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AngularSvgIconModule} from "angular-svg-icon";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {MaterialModule} from "./modules/material.module";
import {TranslocoModule} from "@ngneat/transloco";

@NgModule({
  declarations: [

  ],
  imports: [
    MaterialModule,
    TranslocoModule,
    ReactiveFormsModule,
    FormsModule,
    AngularSvgIconModule.forRoot(),
    HttpClientModule,
    RouterModule
  ],
  exports: [
    MaterialModule,
    TranslocoModule,
  ]
})
export class SharedModule {
  public static injector: Injector;
  constructor(@Optional() @SkipSelf() parentModule: SharedModule,
              injector: Injector) {
    if(parentModule) {
      throw new Error('Shared module is already loaded.');
    }
    SharedModule.injector = injector;
  }
}

import {NgModule} from "@angular/core";
import {MaterialModule} from "../shared/modules/material.module";
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {AngularSvgIconModule} from "angular-svg-icon";
import {TranslocoModule} from "@ngneat/transloco";

@NgModule({
  declarations: [
    //components
  ],
  exports: [
    //components
  ],
  imports: [
    MaterialModule,
    RouterModule,
    HttpClientModule,
    AngularSvgIconModule.forRoot(),
    TranslocoModule
  ]
})
export class HeaderModule {}

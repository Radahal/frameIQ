import {NgModule} from "@angular/core";
import {MaterialModule} from "../shared/modules/material.module";
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {AngularSvgIconModule} from "angular-svg-icon";
import {TranslocoModule} from "@ngneat/transloco";
import {MatIconModule} from "@angular/material/icon";
import {CommonModule} from "@angular/common";
import {SharedModule} from "../shared/shared.module";
import {AppDashboardComponent} from "./components/app-dashboard/app-dashboard.component";


@NgModule({
  declarations: [
    AppDashboardComponent
  ],
  exports: [
    AppDashboardComponent
  ],
  imports: [
    MaterialModule,
    RouterModule,
    HttpClientModule,
    AngularSvgIconModule.forRoot(),
    TranslocoModule,
    MatIconModule,
    CommonModule,
    SharedModule
  ]
})
export class DashboardModule {}

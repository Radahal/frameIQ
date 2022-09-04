import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {AppDashboardComponent} from "./components/app-dashboard/app-dashboard.component";
import {DashboardRoutingModule} from "./dashboard-routing.module";

@NgModule({
  declarations: [
    AppDashboardComponent
  ],
  exports: [
    AppDashboardComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule
  ]
})
export class DashboardModule {}

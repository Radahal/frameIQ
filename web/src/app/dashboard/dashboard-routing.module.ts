import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {AppDashboardComponent} from "./components/app-dashboard/app-dashboard.component";

const routes: Routes = [
  {
    path: '',
    component: AppDashboardComponent
  },
  {
    path: ':proccessingId',
    component: AppDashboardComponent
  },
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule {}

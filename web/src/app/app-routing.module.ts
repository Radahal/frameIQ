import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {AppDashboardComponent} from "./dashboard/components/app-dashboard/app-dashboard.component";

const routes: Routes = [
  { path: 'no-access', component: AppDashboardComponent },
  // { path: '/',
  //   loadChildren: () =>
  //     import("./dashboard/dashboard.module").then(({DashboardModule}) => DashboardModule),
  // }
]

@NgModule({
  imports: [RouterModule.forRoot(routes, {scrollPositionRestoration: 'enabled'})],
  exports: [RouterModule]
})
export class AppRoutingModule {}

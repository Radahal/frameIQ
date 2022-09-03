import {RouterModule, Routes} from "@angular/router";
import {AppComponent} from "./app.component";
import {NgModule} from "@angular/core";

const routes: Routes = [
  { path: 'no-access', component: AppComponent },
  // { path: '/',
  //   loadChildren: () =>
  //     import(".modules/xxx/xxx.module").then(({XModule}) => XModule),
  // }
]

@NgModule({
  imports: [RouterModule.forRoot(routes, {scrollPositionRestoration: 'enabled'})],
  exports: [RouterModule]
})
export class AppRoutingModule {}

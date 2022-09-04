import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {ConfigurationComponent} from "./components/configuration/configuration.component";

const routes: Routes = [
  {
    path: '',
    component: ConfigurationComponent
  },
  {
    path: ':configurationId',
    component: ConfigurationComponent
  },
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ConfigurationRoutingModule {}

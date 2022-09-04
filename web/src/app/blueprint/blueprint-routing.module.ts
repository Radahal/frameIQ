import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {BlueprintComponent} from "./components/blueprint/blueprint.component";

const routes: Routes = [
  {
    path: '',
    component: BlueprintComponent
  },
  {
    path: ':blueprintId',
    component: BlueprintComponent
  },
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BlueprintRoutingModule {}

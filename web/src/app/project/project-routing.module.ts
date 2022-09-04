import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {ProjectComponent} from "./components/project/project.component";

const routes: Routes = [
  {
    path: '',
    component: ProjectComponent,
  },
  {
    path: ':projectId',
    component: ProjectComponent,
  },
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProjectRoutingModule {}

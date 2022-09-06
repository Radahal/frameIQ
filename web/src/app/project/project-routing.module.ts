import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {ProjectContainerComponent} from "./components/project-container/project-container.component";

const routes: Routes = [
  {
    path: '',
    component: ProjectContainerComponent,
  },
  {
    path: ':projectId',
    component: ProjectContainerComponent,
  },
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProjectRoutingModule {}

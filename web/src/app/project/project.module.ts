import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ProjectComponent} from "./components/project/project.component";
import {ProjectRoutingModule} from "./project-routing.module";

@NgModule({
  declarations: [
    ProjectComponent,
  ],
  exports: [
    ProjectComponent
  ],
  imports: [
    CommonModule,
    ProjectRoutingModule
  ]
})
export class ProjectModule {}

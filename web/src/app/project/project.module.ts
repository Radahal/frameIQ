import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ProjectComponent} from "./components/project/project.component";
import {ProjectRoutingModule} from "./project-routing.module";
import {ProjectListComponent} from "./components/project-list/project-list.component";
import {ProjectContainerComponent} from "./components/project-container/project-container.component";
import {TranslocoModule} from "@ngneat/transloco";
import {MatIconModule} from "@angular/material/icon";
import {MatTooltipModule} from "@angular/material/tooltip";

@NgModule({
  declarations: [
    ProjectComponent,
    ProjectListComponent,
    ProjectContainerComponent,
  ],
  exports: [
    ProjectComponent,
    ProjectListComponent,
    ProjectContainerComponent,
  ],
  imports: [
    CommonModule,
    ProjectRoutingModule,
    TranslocoModule,
    MatIconModule,
    MatTooltipModule,
  ]
})
export class ProjectModule {}

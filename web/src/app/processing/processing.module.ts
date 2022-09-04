import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ProcessingComponent} from "./components/processing/processing.component";
import {ProcessingListComponent} from "./components/processing-list/processing-list.component";
import {ProcessingRoutingModule} from "./processing-routing.module";

@NgModule({
  declarations: [
    ProcessingComponent,
    ProcessingListComponent
  ],
  exports: [
    ProcessingComponent,
    ProcessingListComponent
  ],
  imports: [
    CommonModule,
    ProcessingRoutingModule
  ]
})
export class ProcessingModule {}

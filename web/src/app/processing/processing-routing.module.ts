import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {ProcessingComponent} from "./components/processing/processing.component";
import {ProcessingListComponent} from "./components/processing-list/processing-list.component";

const routes: Routes = [
  {
    path: '',
    component: ProcessingListComponent
  },
  {
    path: ':proccessingId',
    component: ProcessingComponent
  },
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProcessingRoutingModule {}

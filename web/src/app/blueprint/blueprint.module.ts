import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {BlueprintComponent} from "./components/blueprint/blueprint.component";
import {BlueprintRoutingModule} from "./blueprint-routing.module";

@NgModule({
  declarations: [
    BlueprintComponent
  ],
  exports: [
    BlueprintComponent
  ],
  imports: [
    CommonModule,
    BlueprintRoutingModule
  ]
})
export class BlueprintModule {}

import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ConfigurationComponent} from "./components/configuration/configuration.component";
import {ConfigurationRoutingModule} from "./configuration-routing.module";

@NgModule({
  declarations: [
    ConfigurationComponent
  ],
  exports: [
    ConfigurationComponent
  ],
  imports: [
    CommonModule,
    ConfigurationRoutingModule
  ]
})
export class ConfigurationModule {}

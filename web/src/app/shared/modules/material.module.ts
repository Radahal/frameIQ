import {NgModule} from "@angular/core";

// navigation
import {MatToolbarModule} from "@angular/material/toolbar";

const materialModules = [
  MatToolbarModule,
]

@NgModule({
  exports: [...materialModules],
})
export class MaterialModule {}

import {NgModule} from "@angular/core";
import {MaterialModule} from "../shared/modules/material.module";
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {AngularSvgIconModule} from "angular-svg-icon";
import {TranslocoModule} from "@ngneat/transloco";
import {AppHeaderComponent} from "./components/header/app-header.component";
import {BreadcrumbsNavComponent} from "./components/breadcrumbs-nav/breadcrumbs-nav.component";
import {MatIconModule} from "@angular/material/icon";
import {CommonModule} from "@angular/common";
import {SharedModule} from "../shared/shared.module";
import {AppLeftMenuComponent} from "./components/app-left-menu/app-left-menu.component";

@NgModule({
  declarations: [
    AppHeaderComponent,
    BreadcrumbsNavComponent,
    AppLeftMenuComponent
  ],
  exports: [
    AppHeaderComponent,
    AppLeftMenuComponent
  ],
  imports: [
    MaterialModule,
    RouterModule,
    HttpClientModule,
    AngularSvgIconModule.forRoot(),
    TranslocoModule,
    MatIconModule,
    CommonModule,
    SharedModule
  ]
})
export class HeaderModule {}

import {Component, OnDestroy, OnInit} from '@angular/core';
import {environment} from "../environments/environment";

@Component({
  selector: 'app-root',
  template: `
    <div class="main-container">
      <app-header></app-header>
      <ng-container>
        <app-left-menu></app-left-menu>
        <div class="content">
          <router-outlet></router-outlet>
        </div>
        <div class="version">v. {{version}}</div>
      </ng-container>
    </div>
  `
})
export class AppComponent implements OnInit, OnDestroy {
  version = environment.version;
  constructor() {

  }

  ngOnDestroy(): void {
  }

  ngOnInit(): void {
  }
}

import {Component, OnDestroy, OnInit} from "@angular/core";
import {TranslocoService} from "@ngneat/transloco";
import {NavigationItem, NavigationItemType} from "../../models/navigation-item.model";

@Component({
  selector: 'app-left-menu',
  templateUrl: `app-left-menu.component.html`,
  styleUrls: [`app-left-menu.component.scss`]
})
export class AppLeftMenuComponent implements OnInit, OnDestroy {
  navigationItems: NavigationItem[] = [
    new NavigationItem(NavigationItemType.DASHBOARD, "app.navigation.dashboard", "", true),
    new NavigationItem(NavigationItemType.PROJECT, "app.navigation.project", "", false),
    new NavigationItem(NavigationItemType.PROCESSING, "app.navigation.processing", "", false),
  ];
  constructor(private translocoService: TranslocoService) {
  }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {

  }

}

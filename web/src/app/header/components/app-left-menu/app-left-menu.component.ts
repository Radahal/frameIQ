import {Component, OnDestroy, OnInit} from "@angular/core";
import {TranslocoService} from "@ngneat/transloco";
import {NavigationItem, NavigationItemType} from "../../models/navigation-item.model";
import {NavigationEnd, Router} from "@angular/router";

@Component({
  selector: 'app-left-menu',
  templateUrl: `app-left-menu.component.html`,
  styleUrls: [`app-left-menu.component.scss`]
})
export class AppLeftMenuComponent implements OnInit, OnDestroy {
  navigationItems: NavigationItem[] = [
    new NavigationItem(NavigationItemType.DASHBOARD, "app.navigation.dashboard", "/dashboard", false),
    new NavigationItem(NavigationItemType.PROJECT, "app.navigation.project", "/projects", false),
    new NavigationItem(NavigationItemType.PROCESSING, "app.navigation.processing", "/processings", false),
  ];
  constructor(private translocoService: TranslocoService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.router.events.subscribe( (event) => {
      if (event instanceof NavigationEnd ) {
        this.refreshRoute(event.url);
      }
    })
  }

  ngOnDestroy(): void {

  }

  private refreshRoute(url: string) {
    this.navigationItems.map((navigationItem) => {
      navigationItem.active = url.startsWith(navigationItem.url);
    })
  }

}

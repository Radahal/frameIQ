import {Component, OnDestroy, OnInit} from "@angular/core";
import {NavigationItem, NavigationItemType} from "../../models/navigation-item.model";
import {NavigationEnd, Router} from "@angular/router";

@Component({
  selector: 'breadcrumbs-nav',
  templateUrl: `breadcrumbs-nav.component.html`,
  styleUrls: [`breadcrumbs-nav.component.scss`]
})
export class BreadcrumbsNavComponent implements OnInit, OnDestroy {
  breadcrumbs: NavigationItem[] = [];

  constructor(private router:Router) {
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

  navigateTo(item: NavigationItem) {
    this.router.navigate([item.url]);
  }

  private refreshRoute(url: string) {
    this.breadcrumbs = []
    let urlSegments = url.split("/");
    urlSegments.splice(0,1);
    for (let i = 0; i + 1 < urlSegments.length; i+=2) {
      let domain = urlSegments[i];
      let dataId = urlSegments[i+1];
      let navigationItemType = this.resolveNavigationItemType(domain);
      let active = i+1 === urlSegments.length - 1;
      this.breadcrumbs.push(new NavigationItem(navigationItemType, this.resolveDataName(navigationItemType, dataId), urlSegments.slice(0, i+2).join("/"), active))
    }
  }

  private resolveNavigationItemType(segment: string) {
    switch (segment) {
      case 'projects':
        return NavigationItemType.PROJECT;
      case 'configurations':
        return NavigationItemType.CONFIGURATION;
      case 'blueprints':
        return NavigationItemType.BLUEPRINT
      case 'processings':
        return NavigationItemType.PROCESSING
      default:
        return NavigationItemType.PROJECT
    }
  }

  private resolveDataName(type: NavigationItemType, dataId: string) {
    return dataId;
  }

}

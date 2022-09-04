import {Component, OnDestroy, OnInit} from "@angular/core";
import {NavigationItem, NavigationItemType} from "../../models/navigation-item.model";
import {Router} from "@angular/router";

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
    this.breadcrumbs.push(new NavigationItem(NavigationItemType.PROJECT, "segment1", "url segment1", false),
      new NavigationItem(NavigationItemType.CONFIGURATION, "segment2", "url segment2", true))
  }

  ngOnDestroy(): void {
  }

  navigateTo(item: NavigationItem) {
    this.router.navigate([item.url]);
  }

}

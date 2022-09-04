import {Pipe, PipeTransform} from "@angular/core";
import {NavigationItemType} from "../../../header/models/navigation-item.model";

@Pipe({
  name: 'navigationLink'
})
export class NavigationLinkPipe implements PipeTransform {
  transform(value: NavigationItemType, ...args: any[]): any {
    switch (value) {
      case NavigationItemType.DASHBOARD:
        return '/dashboard';
      case NavigationItemType.PROJECT:
        return '/projects';
      case NavigationItemType.PROCESSING:
        return '/processings';
    }
  }
}

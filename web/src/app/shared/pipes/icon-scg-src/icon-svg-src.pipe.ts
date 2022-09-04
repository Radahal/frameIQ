import {Pipe, PipeTransform} from "@angular/core";
import {NavigationItemType} from "../../../header/models/navigation-item.model";

@Pipe({
  name: 'matIcon'
})
export class MatIconPipe implements PipeTransform {
  transform(value: NavigationItemType, ...args: any[]): any {
    switch (value) {
      case NavigationItemType.DASHBOARD:
        return 'dashboard';
      case NavigationItemType.PROJECT:
        return 'work';
      case NavigationItemType.CONFIGURATION:
        return 'integration_instructions';
      case NavigationItemType.PROCESSING:
        return 'analytics';
    }
  }
}

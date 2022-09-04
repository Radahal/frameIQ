import {Component} from "@angular/core";
import {TranslocoService} from "@ngneat/transloco";

@Component({
  selector: 'app-header',
  templateUrl: `app-header.component.html`,
  styleUrls: [`app-header.component.scss`]
})
export class AppHeaderComponent {
  constructor(private translocoService: TranslocoService) {
  }
}

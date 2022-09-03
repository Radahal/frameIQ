import {Component, HostBinding, HostListener, NgZone, Optional} from "@angular/core";
import {animate, state, style, transition, trigger} from "@angular/animations";
import {Toast, ToastPackage, ToastrService} from "ngx-toastr";
import {KeyboardKey} from "../../models/keyboard-keys.enum";

@Component({
  selector: '[toastr-custom]',
  templateUrl: 'toastr-custom.component.html',
  styleUrls: ['toastr-custom.component.scss'],
  animations: [
    trigger('flyInOut', [
      state("inactive", style({opacity: 0})),
      state("active", style({opacity: 1})),
      state("removed", style({opacity: 0})),
      transition('inactive => active', animate('{{ easeTime }}ms {{ easing }}')),
      transition('active => removed', animate('{{ easeTime }}ms {{ easing }}')),
    ]),
  ],
  preserveWhitespaces: false
})
export class ToastrCustomComponent extends Toast {
  @HostBinding('attr.tabindex') tabIndex = '0';
  @HostListener('window:keydown', [`$event`])
  closeToast(event: KeyboardEvent) {
    if (event.keyCode === KeyboardKey.Escape || event.keyCode === KeyboardKey.Enter) {
      this.remove();
    }
  }

  constructor(
    protected override toastrService: ToastrService,
    public override toastPackage: ToastPackage,
    @Optional() protected override ngZone: NgZone
  ) {
    super(toastrService,
      toastPackage,
      ngZone);
  }

}

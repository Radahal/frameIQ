import {Component, OnDestroy, OnInit} from "@angular/core";
import {TranslocoService} from "@ngneat/transloco";

@Component({
  selector: 'blueprint',
  templateUrl: `blueprint.component.html`,
  styleUrls: [`blueprint.component.scss`]
})
export class BlueprintComponent implements OnInit, OnDestroy{

  constructor(private translocoService: TranslocoService) {

  }

  ngOnInit(): void {

  }

  ngOnDestroy(): void {

  }
}

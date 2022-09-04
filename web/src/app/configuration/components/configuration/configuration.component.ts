import {Component, OnDestroy, OnInit} from "@angular/core";
import {TranslocoService} from "@ngneat/transloco";

@Component({
  selector: 'configuration',
  templateUrl: `configuration.component.html`,
  styleUrls: [`configuration.component.scss`]
})
export class ConfigurationComponent implements OnInit, OnDestroy{

  constructor(private translocoService: TranslocoService) {

  }

  ngOnInit(): void {

  }

  ngOnDestroy(): void {

  }
}

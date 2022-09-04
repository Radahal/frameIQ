import {Component, OnDestroy, OnInit} from "@angular/core";
import {TranslocoService} from "@ngneat/transloco";

@Component({
  selector: 'processing',
  templateUrl: `./processing.component.html`,
  styleUrls: [`./processing.component.scss`]
})
export class ProcessingComponent implements OnInit, OnDestroy{

  constructor(private translocoService: TranslocoService) {

  }

  ngOnInit(): void {

  }

  ngOnDestroy(): void {

  }
}

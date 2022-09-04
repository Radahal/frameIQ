import {Component, OnDestroy, OnInit} from "@angular/core";
import {TranslocoService} from "@ngneat/transloco";

@Component({
  selector: 'processing-list',
  templateUrl: `./processing-list.component.html`,
  styleUrls: [`./processing-list.component.scss`]
})
export class ProcessingListComponent implements OnInit, OnDestroy{

  constructor(private translocoService: TranslocoService) {

  }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {

  }
}

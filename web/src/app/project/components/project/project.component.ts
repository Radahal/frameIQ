import {Component, OnDestroy, OnInit} from "@angular/core";
import {TranslocoService} from "@ngneat/transloco";
import {Router} from "@angular/router";

@Component({
  selector: 'project',
  templateUrl: `project.component.html`,
  styleUrls: [`project.component.scss`]
})
export class ProjectComponent implements OnInit, OnDestroy{

  constructor(private translocoService: TranslocoService,
              private router: Router) {

  }

  ngOnInit(): void {

  }

  ngOnDestroy(): void {

  }
}

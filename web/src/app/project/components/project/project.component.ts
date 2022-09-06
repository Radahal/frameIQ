import {Component, Input, OnDestroy, OnInit} from "@angular/core";
import {TranslocoService} from "@ngneat/transloco";
import {Router} from "@angular/router";
import {Project} from "../../models/project.model";

@Component({
  selector: 'project',
  templateUrl: `project.component.html`,
  styleUrls: [`project.component.scss`]
})
export class ProjectComponent implements OnInit, OnDestroy{
  @Input("project") project: Project | undefined;

  constructor(private translocoService: TranslocoService,
              private router: Router) {

  }

  ngOnInit(): void {

  }

  ngOnDestroy(): void {

  }
}

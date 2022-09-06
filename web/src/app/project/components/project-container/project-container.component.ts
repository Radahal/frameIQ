import {Component, OnDestroy, OnInit} from "@angular/core";
import {TranslocoService} from "@ngneat/transloco";
import {Router} from "@angular/router";
import {Project} from "../../models/project.model";
import {ProjectService} from "../../services/project-service/project.service";

@Component({
  selector: 'project-container',
  templateUrl: `project-container.component.html`,
  styleUrls: [`project-container.component.scss`],
  providers: [ProjectService]
})
export class ProjectContainerComponent implements OnInit, OnDestroy{
  selectedProject: Project | undefined;

  constructor(private translocoService: TranslocoService,
              private router: Router,
              private projectService: ProjectService) {

  }

  ngOnInit(): void {
    this.readUrlParams();
  }

  ngOnDestroy(): void {

  }

  onProjectSelected(project: Project) {
    this.selectedProject = project;
  }

  readUrlParams() {
    const segments = this.router.url.split("/");
    const projectId = segments[segments.length-1];
    if (projectId !== 'projects') {
      this.initSelectedProject(Number(projectId));
    }
  }

  initSelectedProject(projectId: number) {
    this.projectService.getProject(projectId).subscribe((project) => {
      this.selectedProject = project;
    });
  }
}

import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from "@angular/core";
import {TranslocoService} from "@ngneat/transloco";
import {Router} from "@angular/router";
import {Project} from "../../models/project.model";
import {ProjectService} from "../../services/project-service/project.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'project-list',
  templateUrl: `project-list.component.html`,
  styleUrls: [`project-list.component.scss`],
  providers: [ProjectService]
})
export class ProjectListComponent implements OnInit, OnDestroy{
  @Output("projectSelected") projectSelected: EventEmitter<Project> = new EventEmitter<Project>();
  projects: Project[] = [];
  @Input("selectedProject") selectedProject: Project | undefined;
  subs: Subscription[] = [];


  constructor(private translocoService: TranslocoService,
              private router: Router,
              private projectService: ProjectService) {

  }

  ngOnInit(): void {
    this.initProjects();
  }

  ngOnDestroy(): void {
    this.subs.forEach((sub) => sub.unsubscribe());
  }

  private initProjects(): void {
    this.subs.push(this.projectService.listProjects().subscribe((projects: Project[]) => {
      this.projects = projects;
    }));
  }

  onNewProject(): void {
    console.log("new project")
  }

  onProject(project: Project) {
    this.selectedProject = project;
    this.projectSelected.emit(this.selectedProject);
  }
}

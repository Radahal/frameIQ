import {Injectable} from "@angular/core";
import {ProjectHttpService} from "../project-http-service/project-http.service";
import {CreateProject, EditProject, Project} from "../../models/project.model";
import {catchError, finalize, map, Observable, tap} from "rxjs";

@Injectable({
  providedIn: "root"
})
export class ProjectService {
  constructor(private httpService: ProjectHttpService) {
  }

  listProjects(): Observable<Project[]> {
    return this.httpService.listProjects()
      .pipe(finalize(() => console.log("Projects listed")));
  }

  getProject(projectId: number): Observable<Project> {
    return this.httpService.getProject(projectId)
      .pipe(
        tap((response) => console.log("Project fetched")),
        map( (data) => data),
        catchError( (error) => {
          throw Error(error);
        }),
      );
  }

  createProject(createProject: CreateProject): Observable<Project> {
    return this.httpService.createProject(createProject);
  }

  editProject(projectId: number, editProject: EditProject): Observable<Project> {
    return this.httpService.editProject(projectId, editProject);
  }
}

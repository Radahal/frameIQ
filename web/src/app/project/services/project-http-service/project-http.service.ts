import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CreateProject, EditProject, Project} from "../../models/project.model";
import {Observable} from "rxjs";
import {environment} from "../../../../environments/environment";

@Injectable({
  providedIn: "root"
})
export class ProjectHttpService {
  constructor(private http: HttpClient) {
  }

  listProjects(): Observable<Project[]> {
    return this.http.get<Project[]>(`${environment.baseUrl}/projects`);
  }

  getProject(projectId: number): Observable<Project> {
    return this.http.get<Project>(`${environment.baseUrl}/projects/${projectId}`);
  }

  createProject(body: CreateProject): Observable<Project> {
    return this.http.put<Project>(`${environment.baseUrl}/projects`, body);
  }

  editProject(projectId:number, body: EditProject): Observable<Project> {
    return this.http.patch<Project>(`${environment.baseUrl}/projects/${projectId}`, body);
  }
}

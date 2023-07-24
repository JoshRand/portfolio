import { HttpClient, HttpErrorResponse, HttpEvent, HttpHeaders } from "@angular/common/http";
import { SimplePlaceholderMapper } from "@angular/compiler/src/i18n/serializers/serializer";
import { Injectable } from "@angular/core";
import { Observable, Subscription } from "rxjs";
import { Project } from "../model/project";
import { Slide } from "../model/slide";
import { environment } from "src/environments/environment";
import { env } from "process";

@Injectable({
  providedIn: "root"
})

export class PortfolioService {
  projects: Project[];
  projectsDataSource: Observable<Project[]>;
  projectsSubscription: Subscription;
  errorProjects: string;
  constructor(private httpClient : HttpClient) { }
  project: Project;
  projectDataSource: Observable<Project>;
  projectSubscription: Subscription;
  errorProject: string;
  slide: Slide;
  PORTFOLIO_DATABASE_URI = environment.BASE_URL_BACKEND;
  headers: HttpHeaders = new HttpHeaders();
  getProjects(): Observable<Project[]>
  {
    console.log("getting all projects from " + this.PORTFOLIO_DATABASE_URI);

    this.headers.set("Content-Type", "application/json");

    return this.httpClient.get<Project[]>(this.PORTFOLIO_DATABASE_URI.replace("localhost/","") + "/projects", );
   
  }
  getProject(projectId: number) : Observable<Project>
  {
    console.log("Attempting to retrieve project #"+projectId)
    console.log(this.PORTFOLIO_DATABASE_URI.replace("localhost/","") + "project?id=" + projectId)
    this.headers.set("Content-Type", "application/json");
    this.projectDataSource = this.httpClient.get<Project>(this.PORTFOLIO_DATABASE_URI.replace("localhost/","") + "/project?id=" + projectId);
    return this.projectDataSource;
  }
  saveProject(project): Observable<Project>
  {
    return this.httpClient.put<Project>(this.PORTFOLIO_DATABASE_URI + "project", project);
  }
  deleteImage(image_url, project_id)
  {
    this.slide = new Slide("", image_url);
    return this.httpClient.request('DELETE', this.PORTFOLIO_DATABASE_URI + "slide/" + project_id, {body:this.slide});
  }
  createSlide(slide,project_id): Observable<Project>
  {
    return this.httpClient.post<Project>(this.PORTFOLIO_DATABASE_URI + "slide/" + project_id, slide);
  }
  saveSlide(slide)
  {
    return this.httpClient.put(this.PORTFOLIO_DATABASE_URI + "slide", slide);
  }
}
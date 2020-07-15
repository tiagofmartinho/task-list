import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from './task.model';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) {}

  public getAllTasks(): Observable<Task[]> {
    return this.http.get<Task[]>('http://localhost:8080/api/task/');
  }

  public deleteTask(id: number): Observable<void> {
    return this.http.delete<void>('http://localhost:8080/api/task/' + id);
  }

  public addTask(description: string): Observable<Task> {
    return this.http.post<Task>('http://localhost:8080/api/task/', description);
  }

}

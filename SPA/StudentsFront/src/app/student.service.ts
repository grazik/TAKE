import { Injectable } from '@angular/core';
import {Student} from "./student";
import {Observable, of} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private studentsAPIUrl = 'http://localhost:5000/api/students';

  constructor(private http: HttpClient) {}


  getStudents() : Observable<Student[]> {
    return this.http.get<Student[]>(this.studentsAPIUrl)
  }

  getStudent(id:number) :Observable<Student> {
    return this.http.get<Student>(`${this.studentsAPIUrl}/${id}`);
  }

  updateStudent(student: Student): Observable<any> {
    const url = `${this.studentsAPIUrl}/${student.id}`;
    return this.http.put(url, student, httpOptions);
  }

  createStudent(student: Student): Observable<Student> {
    return this.http.post<Student>(this.studentsAPIUrl, student,
      httpOptions);
  }

  deleteStudent(student: Student | number): Observable<Student> {
    const id = typeof student === 'number' ? student : student.id;
    const url = `${this.studentsAPIUrl}/${id}`;
    return this.http.delete<Student>(url, httpOptions);
  }
}


import {Component, OnInit} from '@angular/core';
import {StudentService} from "../student.service";
import {Student} from "../student";

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.scss']
})
export class StudentsComponent implements OnInit {
  students: Student[];

  constructor(private studentService: StudentService) {
  }

  getStudents() {
    this.studentService.getStudents()
      .subscribe(students => (this.students = students));
  }

  ngOnInit(): void {
    this.getStudents();
  }

  create(index: number, firstName: string, lastName: string) {
    this.studentService.createStudent({
      firstName,
      lastName,
      index,
    } as Student).subscribe(student => {
      this.students.push(student)
    });
  }

  delete(student: Student) {
    this.students = this.students.filter(({id}) => student.id !== id);
    this.studentService.deleteStudent(student).subscribe();
  }
}

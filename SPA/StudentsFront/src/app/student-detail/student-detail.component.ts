import { Component, OnInit } from '@angular/core';
import { Student } from "../student";
import { Location } from '@angular/common';
import { ActivatedRoute } from "@angular/router";
import { StudentService } from "../student.service";

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.scss']
})
export class StudentDetailComponent implements OnInit {
  student: Student;

  constructor(
    private route: ActivatedRoute,
    private studentService: StudentService,
    private location: Location
  ) {}

  getStudent() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.studentService.getStudent(id)
      .subscribe(student => (this.student = student));
  }

  goBack = () => {
    this.location.back();
  }

  save() {
    this.studentService.updateStudent(this.student)
      .subscribe(this.goBack)
  }

  ngOnInit(): void {
    this.getStudent();
  }

}

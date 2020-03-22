package main.java.view.backing;

import main.java.Student;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("dtTableView")
@ViewScoped
public class TableView implements Serializable {

    private List<Student> students;

    @Inject
    private StudentService service;

    @PostConstruct
    public void init() {
        students = service.createStudents(40);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setService(StudentService service) {
        this.service = service;
    }
}
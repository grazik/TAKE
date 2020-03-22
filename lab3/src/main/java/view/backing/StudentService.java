package main.java.view.backing;

import main.java.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Named
@ApplicationScoped
public class StudentService {

    private final static String[] names;

    private final static String[] surnames;

    static {
        names = new String[10];
        names[0] = "Black";
        names[1] = "White";
        names[2] = "Green";
        names[3] = "Red";
        names[4] = "Blue";
        names[5] = "Orange";
        names[6] = "Silver";
        names[7] = "Yellow";
        names[8] = "Brown";
        names[9] = "Maroon";

        surnames = new String[10];
        surnames[0] = "BMW";
        surnames[1] = "Mercedes";
        surnames[2] = "Volvo";
        surnames[3] = "Audi";
        surnames[4] = "Renault";
        surnames[5] = "Fiat";
        surnames[6] = "Volkswagen";
        surnames[7] = "Honda";
        surnames[8] = "Jaguar";
        surnames[9] = "Ford";
    }

    private String getRandomName() {
        return names[(int) (Math.random() * 10)];
    }

    private String getRandomSurname() {
        return surnames[(int) (Math.random() * 10)];
    }

    public List<Student> createStudents(int size) {
        Random r = new Random();

        List<Student> list = new ArrayList<Student>();
        for(int i = 0 ; i < size ; i++) {
            float average = 2 + r.nextFloat() * (5 - 2);
            list.add(new Student(i, getRandomName(), getRandomSurname(),average ));
        }

        return list;
    }

}
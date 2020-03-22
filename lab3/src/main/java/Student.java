package main.java;

public class Student {
    private int ID;
    private String name;
    private String surname;
    private float average;

    public Student(int ID, String name, String surname, float average) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

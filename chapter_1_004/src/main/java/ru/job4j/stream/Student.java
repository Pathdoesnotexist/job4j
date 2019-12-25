package ru.job4j.stream;

public class Student implements Comparable<Student> {
    final private int score;
    private String surname;


    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int compareTo(Student o) {
        return  o.getScore() - this.getScore();
    }

}

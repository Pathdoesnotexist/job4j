package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student studentOne = new Student();
        studentOne.setName("Ivan Kamushkin");
        studentOne.setGroup("SA-18");
        studentOne.setDate("21/08/2018");

        System.out.println(studentOne.getName() + " зачислен в группу " + studentOne.getGroup() + " приказом от " + studentOne.getDate());
    }
}

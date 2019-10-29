package ru.job4j.oop;
public class College {
    public static void main(String[] args) {
        Freshman stepOne = new Freshman();
        Student stepTwo = stepOne;
        Object stepThree = stepOne;
        Object stepFour = new Freshman();
    }

}

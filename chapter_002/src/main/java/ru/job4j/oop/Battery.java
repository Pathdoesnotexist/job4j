package ru.job4j.oop;

import java.util.Timer;

public class Battery {
    private int load;

    public Battery(int charge) {
        this.load = charge;
    }
    public void exchange(Battery another) {

        System.out.println("Перекачка...");
//        if (this.load < another.load) {
            another.load += this.load;
            this.load = 0;
//        } else {
//            this.load += another.load;
//            another.load = 0;
//        }
    }

    public static void main(String[] args) {
        Battery first = new Battery(30);
        Battery second = new Battery(70);
        System.out.println("Заряд первой батареи: " + first.load);
        System.out.println("Заряд второй батареи: " + second.load);
        first.exchange(second);
        System.out.println("Заряд первой батареи: " + first.load);
        System.out.println("Заряд второй батареи: " + second.load);
    }

}
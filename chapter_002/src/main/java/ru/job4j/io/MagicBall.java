package ru.job4j.io;

import java.util.*;

public class MagicBall {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? Я отвечаю \"да\" или \"нет\"");
        System.out.print("Ты спросил меня: \"" + userInput.nextLine() + "\", и мой ответ: \n");
        int answer = new Random().nextInt(3);
        if (answer == 0) {
            System.out.print("Да");
        } else if (answer == 1) {
            System.out.print("Нет");
        } else {
            System.out.print("Будущее туманно");
        }
        userInput.close();
    }
}
package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    private static int stick = 11;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("На столе лежит 11 спичек.\nИгороки по очереди берут от 1 до 3 спичек.\nПроигрывает тот, кто взял последнюю спичку.");
        System.out.println("Введите имя первого игрока: ");
        String playerOne = input.nextLine();
        System.out.println("Введите имя второго игрока: ");
        String playerTwo = input.nextLine();
        String actingPlayer = playerTwo;

        while (stick > 0) {
            actingPlayer = actingPlayer.equals(playerTwo) ? playerOne : playerTwo;
            int answer;
            System.out.println("\nХодит " + actingPlayer);
            do {
                System.out.println("Сколько спичек вы берете? Можно взять от 1 до 3 спичек, но не больше, чем есть на столе.");
                while (!input.hasNextInt()) {
                    System.out.println("Введены некорректные данные. Сколько спичек вы берете?");
                    input.next();
                }
                answer = input.nextInt();
            } while (answer < 0 || answer > 3 && stick - answer < 0);
            stick -= answer;
            System.out.println("На столе осталось " + stick + " спичек.");
        }
        System.out.println(actingPlayer + " забрал последнюю спичку и проиграл!");
        input.close();
    }
}

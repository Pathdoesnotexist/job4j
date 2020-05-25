package ru.job4j.io;

import java.io.*;
import java.util.Scanner;

public class EvenNumberFile {
    public static void main(String[] args) {
        int pointer;
            try (Scanner scanner = new Scanner(new FileInputStream("even.txt"))) {
                while (scanner.hasNext()) {
                    pointer = scanner.nextInt();
                    System.out.println(pointer + ": четное? " + (pointer % 2 == 0));
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
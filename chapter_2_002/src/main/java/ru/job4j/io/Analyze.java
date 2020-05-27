package ru.job4j.io;

import java.io.*;
import java.util.Scanner;

public class Analyze {
    /**
     * Получение из лог-файла периодов времени, когда сервер не работал
     * @param source лог-файл
     * @param target файл для записи периодов времени, когда сервер не работал
     */
    public void unavailable(String source, String target) {
        try (Scanner input = new Scanner(new FileReader(source)); PrintWriter output = new PrintWriter(new FileWriter(target))) {
            String result;
            while (input.hasNextLine()) {
                String nextLine = input.nextLine();
                if (nextLine.charAt(0) == '4' || nextLine.charAt(0) == '5') {
                    result = nextLine.split(" ")[1] + ";";
                    while (input.hasNextLine()) {
                        nextLine = input.nextLine();
                        if (nextLine.charAt(0) == '2') {
                            result += nextLine.split(" ")[1];
                            output.println(result);
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Analyze wrap = new Analyze();
        wrap.unavailable("./chapter_2_002/data/server.log", "./chapter_2_002/data/unavailable.csv");
        BufferedReader br = new BufferedReader(new FileReader("./chapter_2_002/data/unavailable.csv"));
        String i = br.readLine();
        while (!i.isBlank()) {
            System.out.println(i);
        }

    }
}
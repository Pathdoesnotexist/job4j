package ru.job4j.oop;

public class DummyDic {
    public static String engToRus(String eng) {
        return "Неизвестное слово: " + eng;
    }

    public static void main(String[] args) {
        DummyDic toTranslate = new DummyDic();
        System.out.println(toTranslate.engToRus("vocabulary"));
        System.out.println(DummyDic.engToRus("paper"));
    }
}


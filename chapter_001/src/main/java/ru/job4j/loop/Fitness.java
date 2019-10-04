package ru.job4j.loop;
//иван 3 ник 2
public class Fitness {
    public int calc(int ivan, int nik) {
        int month = 0;
        while (ivan < nik){
            ivan *=3;
            nik *=2;
            month++;
        }
        return month;
    }
}
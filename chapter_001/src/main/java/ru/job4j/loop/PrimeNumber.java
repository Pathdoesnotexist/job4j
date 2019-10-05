package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;

        for (int i = 2; i <= finish; i++) {
            count++;
            for (int ii = 2; ii <= i; ii++) {
                if (i % ii == 0 && i != ii) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}

//        for (int i = 2; i <= finish; i++){
//                for (int ii = 2; ii <= i; ii++) {
//                if (i % ii == 0 && i != ii) {
//                break;
//                } else if (i == ii) {
//                count++;
//                }
//                }
//                }
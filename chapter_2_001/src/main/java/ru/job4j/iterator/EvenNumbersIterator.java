package ru.job4j.iterator;

import java.util.Iterator;

public class EvenNumbersIterator implements Iterator<Integer> {
    final int[] numbers;
    private int counter = 0;

    public EvenNumbersIterator(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * проверяет есть ли в коллекции следующий четный элемент
     * @return результат проверки
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = this.counter; i < numbers.length ; i++) {
            if(numbers[i] % 2 == 0) {
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * возвращает четный элемент из коллекции
     * @return слендущее четное из коллекции
     */
    @Override
    public Integer next() {
        int result = 0;
        for (int i = this.counter; i < numbers.length ; i++) {
            if(numbers[i] % 2 == 0) {
                result = numbers[i];
                this.counter = i + 1;
                break;
            }
        }
        return result;
    }
}

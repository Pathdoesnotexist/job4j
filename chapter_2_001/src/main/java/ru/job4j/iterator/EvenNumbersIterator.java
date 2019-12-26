package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Итератор двумерного массива
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 27.12.2019
 */
public class EvenNumbersIterator implements Iterator<Integer> {
    final int[] numbers;
    private int pointer = 0;

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
        for (int i = this.pointer; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                pointer = i;
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
        if(!hasNext()) {
            throw new NoSuchElementException("Even numbers not found");
        }
        return numbers[pointer++];
    }
}

package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Обертка над массивом
 *
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 11.01.2020
 */
public class SimpleArray<T> {
    private final T[] array;
    private int pointer = 0;

    @SuppressWarnings("unchecked")
    public SimpleArray(int size) {
        array = (T[]) new Object[size];
    }

    /**
     * добавляет указанный элемент (model) в первую свободную ячейку
     * @param model - добавляемый элемент
     * @return результат операции
     */
    public boolean add(T model) {
        boolean result = false;
        if (pointer < array.length) {
            array[pointer++] = model;
            result = true;
        }
        return result;
    }

    /**
     * возвращает элемент, расположенный по указанному индексу
     * @param index индекс элемента, который необходимо получить
     */
    public T get(int index) {
        if (index >= pointer) {
            throw new ArrayIndexOutOfBoundsException("Element does not exist");
        }
        return array[index];
    }

    /**
     * заменяет новым элементом элемент в массиве по индексу
     * @param index - индекс элемента-цели
     * @param model - добавляемый элемент
     * @return результат операции
     */
    public boolean set(int index, T model) {
        boolean result = false;
        if (index < pointer) {
            array[index] = model;
            result = true;
        }
        return result;
    }

    /**
     * удаляет элемент по указанному индексу
     * @param index - индекс удаляемого элемента
     * @return результат операции
     */

    public boolean remove(int index) {
        boolean result = false;
        if (index <= pointer - 1) {
            if (index < pointer - 1) {
                System.arraycopy(this.array, index + 1, this.array, index, this.array.length - pointer + 1);
            }
            pointer--;
            this.array[pointer] = null;
            result = true;
            }
        return result;
    }

    /**
     *  возвращает итератор, предназначенный для обхода данной структуры.
     * @return итератор
     */
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int iteratorPointer = -1;

            @Override
            public boolean hasNext() {
                return iteratorPointer < array.length - 1;
            }

            @Override
            public T next() {
                T nextEl;
                if (!hasNext()) {
                    throw new NoSuchElementException("Out of Bounds");
                }
                iteratorPointer++;
                nextEl = array[iteratorPointer];
                return nextEl;
            }
        };
    }
}

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
    private final Object[] array;
    private int pointer = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * добавляет указанный элемент (model) в первую свободную ячейку
     * @param model - добавляемый элемент
     */
    public void add(T model) {
        this.array[pointer++] = model;
    }

    /**
     * возвращает элемент, расположенный по указанному индексу
     * @param index индекс элемента, который необходимо получить
     */
    public Object get(int index) throws ArrayIndexOutOfBoundsException {
        return this.array[index];
    }

    /**
     * заменяет новым элементом элемент в массиве по индексу
     * @param index - индекс элемента-цели
     * @param model - добавляемый элемент
     */
    public void set(int index, T model) throws ArrayIndexOutOfBoundsException {
        this.array[index] = model;
    }

    /**
     * удаляет элемент по указанному индексу
     * @param index - индекс удаляемого элемента
     */
    public void remove(int index) throws ArrayIndexOutOfBoundsException {
        if (index != this.array.length - 1) {
            System.arraycopy(this.array, index + 1, this.array, index, this.array.length - index - 1);
        }
            pointer--;
            this.array[pointer] = null;
    }

    /**
     *  возвращает итератор, предназначенный для обхода данной структуры.
     * @return итератор
     */
    public Iterator<Object> iterator() throws NoSuchElementException {
        return Arrays.asList(this.array).iterator();
    }

}

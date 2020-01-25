package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Контейнер на базе связанного списка
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 21.01.2020
 */
public class SimpleListContainer<E> extends SimpleContainer<E> {

    /**
     * Добавление данных в список
     * @param data добавляемые данные
     */
    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (size == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            newNode.previous = this.last;
            this.last.next = newNode;
            this.last = newNode;
        }
        this.size++;
    }

    /**
     * получение данных по индексу элемента списка
     * @param index индекс элемента
     * @return данные элемента
     */
    public E get(int index) {
        Node<E> result = this.first;
        if (index < size) {
            for (int i = 1; i <= index; i++) {
                result = result.next;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Element does not exist yet.");
        }
        return result.data;
    }
}

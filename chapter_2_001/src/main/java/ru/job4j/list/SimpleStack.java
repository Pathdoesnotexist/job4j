package ru.job4j.list;

/**
 * Простой стек на базе связанного списка
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 22.01.2020
 */
public class SimpleStack<T> extends SimpleListContainer<T> {

    /**
     * Возвращает значение первого элемента и удаляет его из коллекции
     * @return значение удаляемого элемента коллекции
     */
    public T poll() {
        T result = first.data;
        if (size == 1) {
            last = null;
            first = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        size--;
        return result;
    }

    /**
     * Помещает значение в начало коллекции
     * @param value добавляемое в коллекцию значение
     */
    public void push(T value) {
        Node<T> newFirst = new Node<>(value);
        if (size == 0) {
            first = newFirst;
            last = newFirst;
        } else {
            first.previous = newFirst;
            newFirst.next = first;
            first = newFirst;
        }
        this.size++;
    }
}

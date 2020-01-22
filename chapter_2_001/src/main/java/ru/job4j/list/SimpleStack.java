package ru.job4j.list;

/**
 * Простой стэк на базе связанного списка
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
        first = first.next;
        return result;
    }

    /**
     * Помещает значение в коллекцию
     * @param value добавляемое в коллекцию значение
     */
    public void push(T value) {
        add(value);
    }
}

package ru.job4j.list;

/**
 * Простой стек на базе связанного списка
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 22.01.2020
 */
public class SimpleStackContainer<T> {
    private SimpleListContainer<T> listContainer = new SimpleListContainer<>();

    /**
     * Помещает значение в начало коллекции
     * @param value добавляемое в коллекцию значение
     */
    public void push(T value) {
        listContainer.addFirst(value);
    }

    /**
     * Возвращает значение первого элемента и удаляет его из коллекции (LIFO)
     * @return значение удаляемого элемента коллекции
     */
    public T poll() {
        return listContainer.deleteFirst();
    }


}

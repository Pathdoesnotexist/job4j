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
     * Помещает значение в конец коллекции
     * @param value добавляемое в коллекцию значение
     */
    public void push(T value) {
        listContainer.addLast(value);
    }

    /**
     * Возвращает значение последнего добавленного элемента и удаляет его из коллекции (LIFO)
     * @return значение удаляемого элемента коллекции
     */
    public T poll() {
        return listContainer.deleteLast();
    }
}

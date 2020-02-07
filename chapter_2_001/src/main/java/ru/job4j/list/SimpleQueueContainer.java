package ru.job4j.list;

/**
 * Простая очередь на базе связанного списка
 * @author Andrey Varshavsky
 * @version 1.1
 * @since 30.01.2020
 */
public class SimpleQueueContainer<T> {
    private SimpleListContainer<T> defaultContainer = new SimpleListContainer<>();
    private SimpleListContainer<T> reversedContainer = new SimpleListContainer<>();

    /**
     * Помещает значение в начало коллекции
     * @param value добавляемое в коллекцию значение
     */
    public void push(T value) {
        defaultContainer.addFirst(value);
    }

    /**
     * Возвращает значение последнего элемента и удаляет его из коллекции (FIFO)
     * @return значение удаляемого элемента коллекции
     */
    public T poll() {
        if (reversedContainer.getSize() == 0) {
            int count = defaultContainer.getSize();
            for (int i = 0; i < count; i++) {
                reversedContainer.addFirst(defaultContainer.deleteFirst());
            }
        }
        return reversedContainer.deleteFirst();
    }
}

package ru.job4j.list;

public class SimpleQueueContainer<T> extends SimpleStackContainer<T> {
    private SimpleListContainer<T> listContainer = new SimpleListContainer<>();

    /**
     * Помещает значение в начало коллекции
     * @param value добавляемое в коллекцию значение
     */
    public void push(T value) {
        listContainer.addFirst(value);
    }

    /**
     * Возвращает значение последнего элемента и удаляет его из коллекции (FIFO)
     * @return значение удаляемого элемента коллекции
     */
    public T poll() {
        return listContainer.deleteLast();
    }
}

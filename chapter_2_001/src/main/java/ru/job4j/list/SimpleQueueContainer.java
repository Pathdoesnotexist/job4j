package ru.job4j.list;

public class SimpleQueueContainer<T> extends SimpleStackContainer<T> {
    /**
     * Возвращает значение последнего элемента и удаляет его из коллекции (FIFO)
     * @return значение удаляемого элемента коллекции
     */
    @Override
    public T poll() {
        T result = last.data;
        if (size == 1) {
            last = null;
            first = null;
        } else {
            last.previous.next = null;
            last = last.previous;
        }
        size--;
        return result;
    }
}

package ru.job4j.list;

/**
 * Динамический контейнер
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 18.01.2020
 */
public class ListOnArrayContainer<E> extends ArrayContainer<E> {

    public ListOnArrayContainer(int size) {
        super(size);
    }

    /**
     * Добавление элемента в конец списка
     * @param value добавляемый элемент
     */
    public void add(E value) {
        if (pointer == container.length) {
            doubleContainerLength(container);
        }
        container[pointer++] = value;
        this.modCount++;
     }

    /**
     * Получение элемента из списка по индексу
     * @param index индекс элемента списка
     * @return элемент списка
     */

    public E get(int index) {
        if (index >= pointer) {
            throw new ArrayIndexOutOfBoundsException("Element does not exist yet");
        }
        return container[index];
    }
}

package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Динамический контейнер
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 18.01.2020
 */
public class SimpleArrayContainer<E> implements Iterable<E> {
    private Object[] container;
    private int pointer;
    private int modCount;

    public SimpleArrayContainer(int size) {
        container = new Object[size];
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
     * Увеличение длинны массива при переполнении
     * @param container заполненный массив с данными
     */
    private void doubleContainerLength(Object[] container) {
        this.container = Arrays.copyOf(container, container.length * 2);
    }

    /**
     * Получение элемента из списка по индексу
     * @param index индекс элемента списка
     * @return элемент списка
     */

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= pointer) {
            throw new ArrayIndexOutOfBoundsException("Element does not exist yet");
        }
        return (E) container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int expectedModCount = modCount;
            int iteratorPointer = 0;

            private void modifiedOrNot(int modCount) {
            if (expectedModCount < modCount) {
                throw new ConcurrentModificationException("Container has been changed!");
                }
            }

            @Override
            public boolean hasNext() {
                modifiedOrNot(modCount);
                return iteratorPointer < pointer;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                modifiedOrNot(modCount);
                if (!hasNext()) {
                    throw new NoSuchElementException("Element not found");
                }
                return (E) container[iteratorPointer++];
            }
        };
    }
}

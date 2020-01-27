package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Динамический контейнер на базе массива
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 27.01.2020
 */
public class ArrayContainer<E> implements Iterable<E> {
    protected E[] container;
    protected int pointer;
    protected int modCount;

    @SuppressWarnings("unchecked")
    public ArrayContainer(int size) {
        container = (E[]) new Object[size];
    }

    /**
     * Увеличение длинны массива
     * @param container заполненный массив с данными
     */
    protected void doubleContainerLength(E[] container) {
        this.container = Arrays.copyOf(container, container.length * 2);
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
            public E next() {
                modifiedOrNot(modCount);
                if (!hasNext()) {
                    throw new NoSuchElementException("Element not found");
                }
                return container[iteratorPointer++];
            }
        };
    }
}

package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Контейнер на базе связанного списка
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 21.01.2020
 */
public class SimpleListContainer<E> implements Iterable<E> {
    Node<E> first;
    private int size;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = this.first;
        this.first = newNode;
        this.size++;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            final int iterableSize = size;
            int iteratorPointer = 0;
            Node<E> nextNode;

            private void modifiedOrNot(int actualSize) {
                if (iterableSize != actualSize) {
                    throw new ConcurrentModificationException("Container has been changed!");
                }
            }

            @Override
            public boolean hasNext() {
                modifiedOrNot(size);
                return iteratorPointer < iterableSize;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                modifiedOrNot(size);
                if (!hasNext()) {
                    throw new NoSuchElementException("Element not found");
                }
                if (iteratorPointer == 0) {
                    nextNode = first;
                } else {
                    nextNode = nextNode.next;
                }
                iteratorPointer++;
                return (E) nextNode;
            }
        };
    }

    /**
     * Класс предназначен для хранения данных.
     */
    static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}

package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleContainer<E> implements Iterable<E> {
    Node<E> first;
    Node<E> last;
    int size = 0;

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            final int iterableSize = size;
            int iteratorPointer = 0;
            Node<E> nextNode = first;

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
                if (iteratorPointer > 0) {
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
        Node<E> previous;

        Node(E data) {
            this.data = data;
        }
    }
}

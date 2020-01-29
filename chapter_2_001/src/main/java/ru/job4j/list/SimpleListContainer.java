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
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    /**
     * Добавление данных в конец коллекции
     * @param value добавляемые данные
     */
    public void addLast(E value) {
        Node<E> newNode = new Node<>(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.previous = this.tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Добавление данных в начало коллекции
     * @param value добавляемые данные
     */
    public void addFirst(E value) {
        Node<E> newFirst = new Node<>(value);
        if (size == 0) {
            head = newFirst;
            tail = newFirst;
        } else {
            head.previous = newFirst;
            newFirst.next = head;
            head = newFirst;
        }
        size++;
    }

    /**
     * Возвращает значение первого элемента и удаляет его из коллекции
     * @return значение удаляемого элемента коллекции
     */
    public E deleteFirst() {
        E result = head.data;
        if (size == 1) {
            tail = null;
            head = null;
        } else {
            head = head.next;
            head.previous = null;
        }
        size--;
        return result;
    }

    /**
     * Возвращает значение последнего элемента и удаляет его из коллекции
     * @return значение удаляемого элемента коллекции
     */
    public E deleteLast() {
        E result = tail.data;
        if (size == 1) {
            tail = null;
            head = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        size--;
        return result;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException("Element does not exist yet.");
        }
        Node<E> result = this.head;
        for (int i = 1; i <= index; i++) {
            result = result.next;
        }
        return result.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            final int iterableSize = size;
            int iteratorPointer = 0;
            Node<E> nextNode = head;

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

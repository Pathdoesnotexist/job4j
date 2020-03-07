package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Ассоциативный массив на базе хэш-таблицы
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 24.02.2020
 */

public class SimpleHashMap<K, V> implements Iterable<V> {
    private static final double loadFactor = 0.75;
    private Node<K, V>[] hashTable;
    private double threshold;
    private int valuableSize = 0;


    @SuppressWarnings("unchecked")
    public SimpleHashMap() {
        this.hashTable = new Node[16];
        this.threshold = hashTable.length * loadFactor;
    }

    /**
     * Добавление пары "ключ-значение" в карту
     * @param key ключ добавляемого значения
     * @param value значение ключа
     * @return результат операции
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        if (valuableSize + 1 >= threshold) {
            expandHashTable();
        }
        Node<K, V> newNode = new Node<>(key, value);
        int index = indexFor(key);
        if (hashTable[index] == null) {
            hashTable[index] = newNode;
            valuableSize++;
            result = true;
        } else if (key == null || key.equals(hashTable[index].getKey())) {
            hashTable[index] = newNode;
            result = true;
        }
        return result;
    }
    /**
     * Удвоение размера массива
     */
    @SuppressWarnings("unchecked")
    private void expandHashTable() {
        Node<K, V>[] newHashTable = new Node[hashTable.length * 2];
        for (Node<K, V> node : hashTable) {
            if (node != null) {
                newHashTable[indexFor(node.getKey())] = node;
            }
        }
        hashTable = newHashTable;
        threshold = hashTable.length * loadFactor;
    }
    /**
     * Определение индекса корзины в таблице для новой ноды
     * @return индекс корзины
     */
    private int indexFor(K key) {
        int h = 0;
        if (key != null) {
            h = 37;
            h = h * 29 + key.hashCode();
            h = h * 29;
            h ^= (h >>> 20) ^ (h >>> 12);
            h = Math.abs(h % hashTable.length);
        }
        return h;
    }

    /**
     * Получение значения по ключу
     * @param key ключ значения, которое необходимо получить
     * @return значение
     */
    public V get(K key) {
        V result = null;
        int index = indexFor(key);
        if (hashTable[index] != null && (key == null || key.equals(hashTable[index].getKey()))) {
            result  = hashTable[index].getValue();
        }
        return result;
    }
    /**
     * Удаление пары "ключ-значение" по ключу
     * @param key ключ удаляемой пары
     * @return результат операции
     */
    public boolean delete(K key) {
        boolean result = false;
        int index = indexFor(key);
        if (hashTable[index] != null && (key == null || key.equals(hashTable[index].getKey()))) {
            hashTable[index] = null;
            valuableSize--;
            result = true;
        }
        return result;
    }

    /**
     * Нода для хранения пары "ключ-значение"
     * @param <K> ключ
     * @param <V> значение
     */
    private static class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    /**
     * Итератор значений
     * @return итератор
     */
    @Override
    public Iterator<V> iterator() {
        return new Iterator<>() {
            final int iterableSize = valuableSize;
            int iteratorPointer = 0;

            private void modifiedOrNot(int actualSize) {
                if (iterableSize != actualSize) {
                    throw new ConcurrentModificationException("Container has been changed!");
                }
            }

            @Override
            public boolean hasNext() {
                modifiedOrNot(valuableSize);
                return iteratorPointer < iterableSize;
            }

            @Override
            @SuppressWarnings("unchecked")
            public V next() {
                V answer;
                if (!hasNext()) {
                    throw new NoSuchElementException("Element not found");
                }
                int i = iteratorPointer;
                while (hashTable[i] == null) {
                    i++;
                }
                answer = (V) hashTable[i];
                iteratorPointer = ++i;
                return answer;
            }
        };
    }
}

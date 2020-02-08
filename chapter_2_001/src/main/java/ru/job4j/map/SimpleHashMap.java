package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Ассоциативный массив на базе хэш-таблицы
 * @author Andrey Varshavsky
 * @version 0.9
 * @since 07.02.2020
 */

public class SimpleHashMap<K, V> implements Iterable<V> {
    private Node<K, V>[] hashTable;
    private float threshold;
    private int valuableSize = 0;

    @SuppressWarnings("unchecked")
    public SimpleHashMap() {
        this.hashTable = new Node[16];
        this.threshold = hashTable.length * 0.75f;
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
            threshold *= 2;
        }
        Node<K, V> newNode = new Node<>(key, value);
        int index = indexFor(newNode.hashCode());
        System.out.println("для пары " + newNode.toString() + " выбран индекс: " + index); ///////////////////////////////////////////////////
        if (hashTable[index] == null) {
            hashTable[index] = newNode;
            valuableSize++;
            result = true;
        } else if (newNode.getKey() == null || newNode.equals(hashTable[index])) {
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
                newHashTable[indexFor(node.hashCode())] = node;
            }
        }
        hashTable = newHashTable;
    }
    /**
     * Определение индекса корзины в таблице для новой ноды
     * @return индекс корзины
     */
    private int indexFor(int h) {
        if (h == 0) {
            return 0;
        } else {
            h ^= (h >>> 20) ^ (h >>> 12);
            return Math.abs(h % hashTable.length);
        }
    }
    /**
     * Получение значения по ключу
     * @param key ключ значения, которое необходимо получить
     * @return значение
     */
    public V get(K key) throws Exception {
        int index = indexByKey(key);
        if (index < 0) {
            throw new Exception("The key does not exist!");
        }
        return hashTable[index].getValue();
    }
    /**
     * Удаление пары "ключ-значение" по ключу
     * @param key ключ удаляемой пары
     * @return результат операции
     */
    public boolean delete(K key) {
        boolean result = false;
        int index = indexByKey(key);
        if (index >= 0) {
            hashTable[index] = null;
            valuableSize--;
            result = true;
        }
        return result;
    }
    /**
     * Получение индекса ноды по ключу
     * @param key ключ ноды
     * @return индекс или -1
     */
    private int indexByKey(K key) {
        Node<K, V> node = new Node<>(key, null);
        int index = indexFor(node.hashCode());
        if (hashTable[index] != null && hashTable[index].equals(node)) {
            return index;
        } else {
            return -1;
        }
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

        @Override
        public int hashCode() {
            if (key == null) {
                return 0;
            } else {
                int hash = 37;
                hash = hash * 29 + key.hashCode();
                return hash * 29;
            }
        }

        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            } else if (this == obj) {
                return true;
            } else if (this.getClass().equals(obj.getClass())) {
                Node<K, V> nodeObj = (Node<K, V>) obj;
                return this.key.equals(nodeObj.key);
            }
            return false;
        }

        @Override
        public String toString() {
            return "Key: " + key + " Value:" + value;
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

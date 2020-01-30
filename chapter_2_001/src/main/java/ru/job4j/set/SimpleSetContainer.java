package ru.job4j.set;

import ru.job4j.list.SimpleArrayContainer;

import java.util.Iterator;
/**
 * Реализация множества на основе массива
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 28.01.2020
 */
public class SimpleSetContainer<E> {
    SimpleArrayContainer<E> container = new SimpleArrayContainer<>(10);


    /**
     * Добавление элемента в список
     * @param value добавляемый элемент
     */
    public boolean add(E value) {
        boolean result = false;
        if (!contains(value)) {
            container.add(value);
            result = true;
        }
        return result;
    }

    private boolean contains(E value) {
        boolean result = false;
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public Iterator<E> iterator() {
        return container.iterator();
    }
}

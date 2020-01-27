package ru.job4j.set;

import ru.job4j.list.ArrayContainer;
import ru.job4j.list.ListOnArrayContainer;

public class SetOnArrayContainer<E> extends ArrayContainer<E> {
    public SetOnArrayContainer(int size) {
        super(size);
    }

    /**
     * Добавление элемента в список
     * @param value добавляемый элемент
     */
    public boolean add(E value) {
        boolean result = true;
        if (pointer == container.length) {
            doubleContainerLength(container);
        }
        for (E item : container) {
            if (item != null && item.equals(value)) {
                result = false;
                break;
            }
        }
        if (result) {
            container[pointer++] = value;
            this.modCount++;
        }
        return result;
    }
}

package ru.job4j.list;

import java.util.Iterator;

/**
 * Динамический контейнер
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 18.01.2020
 */

public class SimpleContainer<E> implements Iterable<E> {
    Object[] container;
    int pointer;

    /**
     * Добавление элемента в конец списка
     * @param value добавляемый элемент
     */
    public void add(E value) {
        if (pointer == container.length) {
            adjustContainerLength();
        }


     }

    /**
     * Увеличение длинны списка при переполнении
     *
     */
    private void adjustContainerLength() {

    }

    /**
     * Получение элемента из списка по индексу
     * @param index индекс элемента списка
     * @return элемент списка
     */
    public E get(int index) {

        return null;
    }
//    Итератор должен реализовывать fail-fast поведение, т.е. если с момента создания итератора коллекция подверглась структурному
//    изменению, итератор должен кидать ConcurrentModificationException.
//    Это достигается через введение счетчика изменений - modCount.
//    Каждая операция, которая структурно модифицирует коллекцию должна инкрементировать этот счетчик.
//    В свою очередь итератор запоминает значение этого счетчика на момент своего создания (expectedModCount),
//    а затем на каждой итерации сравнивает сохраненное значение, с текущим значением поля modCount,
//    если они отличаются, то генерируется исключение.
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }
}

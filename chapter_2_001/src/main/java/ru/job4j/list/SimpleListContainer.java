package ru.job4j.list;

import java.util.Iterator;

public class SimpleListContainer<E> implements Iterable<E> {



    public void add(E value) {

    }

    public E get(int index) {

        return null;
    }




//    Итератор должен реализовывать fail-fast поведение, т.е. если с момента создания итератора коллекция подверглась структурному
//        изменению, итератор должен кидать ConcurrentModificationException.
//    Это достигается через введение счетчика изменений - modCount. Каждая операция, которая структурно модифицирует коллекцию
//    должна инкрементировать этот счетчик. В свою очередь итератор запоминает значение этого счетчика на момент своего
//    создания (expectedModCount), а затем на каждой итерации сравнивает сохраненное значение, с текущим значением поля modCount,
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

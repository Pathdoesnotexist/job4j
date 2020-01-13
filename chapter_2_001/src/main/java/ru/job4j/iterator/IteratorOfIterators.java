package ru.job4j.iterator;


import org.w3c.dom.ls.LSOutput;

import java.util.*;

/**
 * Итератор итераторов
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 27.12.2019
 */

public class IteratorOfIterators {

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> its) {
        return new Iterator<Integer>() {
            Iterator<Integer> inner = its.next();

            @Override
            public boolean hasNext() {
                while (its.hasNext() && !inner.hasNext()){
                    inner = its.next();
                }
                return inner.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No data found");
                }
                return inner.next();
            }
        };
    }
}
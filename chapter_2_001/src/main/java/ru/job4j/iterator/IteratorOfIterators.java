package ru.job4j.iterator;


import java.util.*;

/**
 * Итератор итераторов
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 27.12.2019
 */

public class IteratorOfIterators {

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> its) {
        return new Iterator<>() {
            Iterator<Integer> inner = its.next();

            @Override
            public boolean hasNext() {
                boolean hasNext = false;
                if (inner != null) {
                    hasNext = inner.hasNext();
                    if ((!hasNext) && (its.hasNext())) {
                        inner = its.next();
                        hasNext = inner.hasNext();
                    }
                }
                return hasNext;
            }

            @Override
            public Integer next() {
                Integer next;
                if (inner.hasNext()) {
                    next = inner.next();
                } else if (its.hasNext()) {
                        inner = its.next();
                        next = inner.next();
                    } else {
                        throw new NoSuchElementException("No data found");
                    }
                return next;
            }
        };
    }
}




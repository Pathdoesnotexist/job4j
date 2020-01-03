package ru.job4j.iterator;


import java.util.*;

/**
 * CLASSDESC_CLASSDESC_CLASSDESC_CLASSDESC_CLASSDESC_CLASSDESC_CLASSDESC_CLASSDESC
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 27.12.2019
 */
public class IteratorOfIterators implements Iterator<Iterator<Integer>> {
//   Метод convert должен принимать объект итератор итератор и возвращать Итератор чисел.
//   Iterator<Iterator<Integer> - ((4 2 0 4 6 4 9), (0 9 8 7 5), (1 3 5 6 7 0 9 8 4))
//   Метод должен возвращать
//   Iterator<Integer> - (4 2 0 4 6 4 9 0 9 8 7 5 1 3 5 6 7 0 9 8 4)
//   Метод не должен копировать данные. Нужно реализовать итератор, который будет пробегать по вложенными итераторам без копирования данных.

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> its) {
        List<Integer> list = new ArrayList<>();
        while (its.hasNext()) {
            Iterator<Integer> it = its.next();
//            System.out.println(Arrays.asList(it));

            while (it.hasNext()) {
                Integer i = it.next();
                list.add(i);
//                System.out.println(i);
            }
        }
        return list.iterator();
    }
    /**
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<Integer> next() {
        return null;
    }


//    public static void main(String[] args) {
//        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
//        Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
//        Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
//        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
//        IteratorOfIterators iteratorIterator = new IteratorOfIterators();
//        Iterator<Integer> it = iteratorIterator.convert(its);
//        while (it.hasNext()) {
//            System.out.print(it.next() + " ");
//        }
//    }
}

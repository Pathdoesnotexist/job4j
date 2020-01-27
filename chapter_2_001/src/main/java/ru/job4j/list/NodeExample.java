package ru.job4j.list;

/**
 * Односвязный список с проверкой на замыкания
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 27.01.2020
 */
public class NodeExample<T> {
    public final T value;
    public NodeExample<T> next;

    public NodeExample(T value) {
        this.value = value;
    }

    /**
     * Проверка списка на цикличные замыкания
     * @param first первый элемент проверяемого списка
     * @return результат проверки
     */
    public boolean hasCycle(NodeExample<T> first) {
        boolean result = false;
        if (first != null) {
            NodeExample<T> slowPointer = first;
            NodeExample<T> fastPointer = first.next;
            while (fastPointer != null && fastPointer.next != null) {
                if (slowPointer.value.equals(fastPointer.value)) {
                    result = true;
                    break;
                }
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
        }
        return result;
    }
}
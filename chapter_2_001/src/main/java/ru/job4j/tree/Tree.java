package ru.job4j.tree;

import java.util.*;

/**
 * Простое дерево
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 28.02.2020
 */

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E value) {
        this.root = new Node<>(value);
    }
    /**
     * Метод добавления дочерней ноды в выбранную родительскую
     * @param parent родительская нода
     * @param child дочерняя нода для добавления в родительскую
     * @return результат операции
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rsl = true;
        Optional<Node<E>> parentNode = findBy(parent);
        Optional<Node<E>> childNode = findBy(child);
        if (parentNode.isEmpty() || childNode.isPresent()) {
            rsl = false;
        } else {
            parentNode.get().children.add(new Node<>(child));
        }
        return rsl;
    }
    /**
     * поиск ноды по хранящемуся значению.
     * @param value значение ноды для поиска
     * @return ноду по значению или null
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
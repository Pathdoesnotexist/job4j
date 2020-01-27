package ru.job4j.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeExampleTest {

    private NodeExample<Integer> first;
    private NodeExample<Integer> two;
    private NodeExample<Integer> third;
    private NodeExample<Integer> four;

    @Before
    public void before() {
        first = new NodeExample<>(1);
        two = new NodeExample<>(2);
        third = new NodeExample<>(3);
        four = new NodeExample<>(4);
    }


    @Test
    public void whenHasCycleShouldTrue() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertTrue(first.hasCycle(first));
    }

    @Test
    public void whenHasCycleInsideShouldTrue() {
        first.next = two;
        two.next = third;
        third.next = two;
        four.next = first;
        assertTrue(first.hasCycle(first));
    }

    @Test
    public void whenHasNoCycleShouldFalse() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertFalse(first.hasCycle(first));
    }

    @Test
    public void whenHasBigListCycleShouldTrue() {

        NodeExample<Integer> first = new NodeExample<>(1);
        NodeExample<Integer> node = first;

        for (int i = 2; i < 100000; i++) {
            NodeExample<Integer> next = new NodeExample<>(i);
            node.next = next;
            node = next;
        }

        node.next = first;
        assertTrue(first.hasCycle(first));
    }

    @Test
    public void whenHasBigListNoCycleShouldFalse() {

        NodeExample<Integer> first = new NodeExample<>(1);
        NodeExample<Integer> node = first;

        for (int i = 2; i < 100000; i++) {
            NodeExample<Integer> next = new NodeExample<>(i);
            node.next = next;
            node = next;
        }

        assertFalse(first.hasCycle(first));
    }


}

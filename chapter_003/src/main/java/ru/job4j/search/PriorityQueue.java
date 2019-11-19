package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param newTask задача
     */
    public void put(Task newTask) {
        int position = 0;
            for (Task task : tasks) {
                if (task.getPriority() > newTask.getPriority()) {
                    break;
                }
                position++;
            }
        this.tasks.add(position, newTask);
    }

    public Task take() {
        return this.tasks.poll();
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("test", 5));
        queue.put(new Task("test", 1));
        queue.put(new Task("test", 3));
        queue.put(new Task("test", 2));
        queue.put(new Task("test", 4));
        queue.put(new Task("test", 0));
        queue.put(new Task("test", 40));

        for (Task task : queue.tasks) {
            System.out.println("Идет элемент с приоритетом " + task.getPriority());
        }

    }

}
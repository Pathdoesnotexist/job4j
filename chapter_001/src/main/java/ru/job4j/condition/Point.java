package ru.job4j.condition;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public double distance(Point another){
        return Math.sqrt(Math.pow((this.x - another.x), 2) + Math.pow((this.y - another.y), 2));
    }

    public static void main(String[] args) {
        Point first = new Point(0, 0);
        Point second = new Point(2, 0);
        System.out.println(first.distance(second));

        Point third = new Point(10, -5);
        Point forth = new Point(5, 1);
        System.out.println(third.distance(forth));
    }
}

package ru.job4j.condition;

public class Point {
    private int x;
    private int y;
    private int z;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public  Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point another){
        return Math.sqrt(Math.pow((this.x - another.x), 2) + Math.pow((this.y - another.y), 2));
    }
    public double distance3d(Point another) {
        return Math.sqrt(Math.pow((this.x - another.x), 2) + Math.pow((this.y - another.y), 2) + Math.pow((this.z - another.z), 2));
    }


    public static void main(String[] args) {
        Point first = new Point(0, 0);
        Point second = new Point(2, 0);
        System.out.println(first.distance(second));

        Point third = new Point(10, -5);
        Point forth = new Point(5, 1);
        System.out.println(third.distance(forth));

        Point first3d = new Point(10, -5, 0);
        Point second3d = new Point(5, 1, 4);
        System.out.println(first3d.distance3d(second3d));
    }
}

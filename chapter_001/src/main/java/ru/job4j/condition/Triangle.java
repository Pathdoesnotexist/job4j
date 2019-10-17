package ru.job4j.condition;

public class Triangle {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;

    public Triangle(Point ap, Point bp, Point cp) {
        this.firstPoint = ap;
        this.secondPoint = bp;
        this.thirdPoint = cp;
    }

    /**
     * Метод проверяет можно ли построить треугольник с заданными координатами вершин.
     * @return false - если фигура точка или отрезок. true - треугольник
     */
    public boolean exist() {
        double ab =  firstPoint.distance(secondPoint);
        double bc =  secondPoint.distance(thirdPoint);
        double ac =  thirdPoint.distance(firstPoint);
        return ab != 0 && bc != 0 && ac != 0;
    }

    /**
     * Метод вычисления периметра по длинам сторон.
     * @return Периметр или -1 если треугольник не существует
     */
    public double period() {
        if (this.exist()) {
            double ab = firstPoint.distance(secondPoint);
            double bc = secondPoint.distance(thirdPoint);
            double ac = thirdPoint.distance(firstPoint);
            return ab + bc + ac;
        } else {
            return -1;
        }
    }

    /**
     * Метод вычисляет площадь треугольника по формуле.
     * @return площадь треугольника или -1 если треугольник не существует
     */
    public double area() {
        if (this.exist()) {
            double ab = firstPoint.distance(secondPoint);
            double bc = firstPoint.distance(thirdPoint);
            double ac = secondPoint.distance(thirdPoint);
            double p = this.period()/2;
        return Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Point a = new Point(0,2);
        Point b = new Point(1,4);
        Point c = new Point(4,0);
        Triangle exampleOne = new Triangle(a, b, c);
        System.out.println(exampleOne.exist());
        System.out.println(exampleOne.area());
        System.out.println(exampleOne.period());

        Point a2 = new Point(0,0);
        Point b2 = new Point(0,0);
        Point c2 = new Point(0,0);
        Triangle exampleTwo = new Triangle(a2, b2, c2);
        System.out.println(exampleTwo.exist());
        System.out.println(exampleTwo.area());
        System.out.println(exampleTwo.period());
    }
}





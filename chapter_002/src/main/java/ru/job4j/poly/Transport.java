package ru.job4j.poly;
// В интерфейсе объявите три метода: ехать (без параметров, без возвращаемого типа), пассажиры (принимает число пассажиров, без возвращаемого типа),
// заправить (принимает кол-во топлива, возвращает цену).
//3. Реализуйте этот интерфейс в классе ru.job4j.poly.Bus.
//Внутри методов напишите минимально требуемый код.
//4. Добавьте ссылку с коммитом в эту задачу и измените ответственного на Петра Арсентьева.
public interface Transport {
    void move();
    void passengers( int count);
    double refillPrice (double fuel);
}
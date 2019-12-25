package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Автобус поехал");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиров в автобусе: " + count);
    }

    @Override
    public double refillPrice(double fuel) {
        double price = 42.1;
        return price * fuel;
    }
}

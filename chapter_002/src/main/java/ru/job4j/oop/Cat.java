package ru.job4j.oop;
//1. Создайте дополнительное поле private String name. Это поле должно содержать кличку котика.
//2. Создайте метод public void giveNick(String nick). Этот метод должен записывать переменную nick в поле name.
//3. Измените метод void show() так, чтобы при его вызове в консоль выводилась информация: имя котика и что он ел.
public class Cat {
    private String food;
    private String name;

    public void show(){
        System.out.println("Cat " + this.name + " is eating " + this.food + ".");
    }
    public String voiceSound(){
        String voice = "meow-meow!";
        return voice;
    }
    public void eat(String meat) {
        this.food = meat;
    }
    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        System.out.println("There are Gav's food.");
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("beaf");
        gav.show();
        System.out.println("There are Black's food.");
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}

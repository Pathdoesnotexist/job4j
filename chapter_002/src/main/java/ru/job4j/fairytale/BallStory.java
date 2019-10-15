package ru.job4j.fairytale;

public class BallStory {

    public static void main(String[] args) {
        Ball kolobok = new Ball();
        kolobok.setName("колобок");
        Hare hare = new Hare();
        hare.setName("зайчик");
        Wolf wolf = new Wolf();
        wolf.setName("серый волк");
        Bear bear = new Bear();
        bear.setName("медведь");
        Fox fox = new Fox();
        fox.setName("лиса");

        kolobok.runAway();
        hare.tryEat(kolobok);
        kolobok.runAway();
        wolf.tryEat(kolobok);
        kolobok.runAway();
        bear.tryEat(kolobok);
        kolobok.runAway();
        fox.tryEat(kolobok);

    }
}

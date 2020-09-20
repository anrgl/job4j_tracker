package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare fastHare = new Hare();
        Wolf sadWolf = new Wolf();
        Fox slyFox = new Fox();

        fastHare.tryEat(ball);
        sadWolf.tryEat(ball);
        slyFox.tryEat(ball);
    }
}

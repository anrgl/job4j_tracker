package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox song1 = new Jukebox();
        song1.music(1);
        Jukebox song2 = new Jukebox();
        song2.music(2);
        Jukebox noSong = new Jukebox();
        noSong.music(3);
    }
}

package org.example;

public class BardAdapter implements Character {
    private Bard bard;

    public BardAdapter(Bard bard) {
        this.bard = bard;
    }

    public void move() {
        System.out.println("Bard cannot move during performance");
    }

    public void attack() {
        bard.annoy();
    }

    public void defend() {
        bard.playMusic();
    }
}

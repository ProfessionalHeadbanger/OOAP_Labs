package org.example;

public class AssassinAdapter implements Character {
    private Assassin assassin;

    public AssassinAdapter(Assassin assassin) {
        this.assassin = assassin;
    }

    public void move() {
        assassin.stealth();
    }

    public void attack() {
        assassin.usePoison();
    }

    public void defend() {
        System.out.println("Assassin relies on evasion and stealth");
    }
}

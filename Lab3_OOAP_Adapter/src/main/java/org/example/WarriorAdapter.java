package org.example;

public class WarriorAdapter implements Character{
    private Warrior warrior;

    public WarriorAdapter(Warrior warrior) {
        this.warrior = warrior;
    }

    public void move() {
        warrior.rolling();
    }

    public void attack() {
        warrior.hit();
    }

    public void defend() {
        warrior.block();
    }
}

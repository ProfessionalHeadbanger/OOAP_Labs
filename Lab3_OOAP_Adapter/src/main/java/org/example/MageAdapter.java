package org.example;

public class MageAdapter implements Character {
    private Mage mage;

    public MageAdapter(Mage mage) {
        this.mage = mage;
    }

    public void move() {
        mage.teleport();
    }

    public void attack() {
        mage.castSpell();
    }

    public void defend() {
        System.out.println("Mage cannot defend directly - relies on spells");
    }
}

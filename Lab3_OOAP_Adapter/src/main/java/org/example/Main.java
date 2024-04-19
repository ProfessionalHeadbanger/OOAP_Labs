package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        Mage mage = new Mage();
        Bard bard = new Bard();
        Assassin assassin = new Assassin();

        Character warriorCharacter = new WarriorAdapter(warrior);
        Character mageCharacter = new MageAdapter(mage);
        Character bardCharacter = new BardAdapter(bard);
        Character assassinCharacter = new AssassinAdapter(assassin);

        System.out.println("Warrior's turn:");
        warriorCharacter.move();
        warriorCharacter.attack();
        warriorCharacter.defend();
        System.out.println();

        System.out.println("Mage's turn:");
        mageCharacter.move();
        mageCharacter.attack();
        mageCharacter.defend();
        System.out.println();

        System.out.println("Bard's turn:");
        bardCharacter.move();
        bardCharacter.attack();
        bardCharacter.defend();
        System.out.println();

        System.out.println("Assassin's turn:");
        assassinCharacter.move();
        assassinCharacter.attack();
        assassinCharacter.defend();
    }
}
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.Character;
import org.example.Warrior;
import org.example.WarriorAdapter;
import org.example.Mage;
import org.example.MageAdapter;
import org.example.Bard;
import org.example.BardAdapter;
import org.example.Assassin;
import org.example.AssassinAdapter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Tests {

    private final PrintStream standartOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void WarriorTestMove() {
        Warrior warrior = new Warrior();
        Character warriorCharacter = new WarriorAdapter(warrior);
        warriorCharacter.move();
        assertEquals("Warrior is rollin'-rollin'-rollin'", outputStream.toString().trim());
    }

    @Test
    public void WarriorTestAttack() {
        Warrior warrior = new Warrior();
        Character warriorCharacter = new WarriorAdapter(warrior);
        warriorCharacter.attack();
        assertEquals("Warrior is hitting on the head", outputStream.toString().trim());
    }

    @Test
    public void WarriorTestDefend() {
        Warrior warrior = new Warrior();
        Character warriorCharacter = new WarriorAdapter(warrior);
        warriorCharacter.defend();
        assertEquals("Warrior is putting a block", outputStream.toString().trim());
    }

    @Test
    public void MageTestMove() {
        Mage mage = new Mage();
        Character mageCharacter = new MageAdapter(mage);
        mageCharacter.move();
        assertEquals("Mage is teleporting, BLINK!", outputStream.toString().trim());
    }

    @Test
    public void MageTestAttack() {
        Mage mage = new Mage();
        Character mageCharacter = new MageAdapter(mage);
        mageCharacter.attack();
        assertEquals("Mage is casting a spell", outputStream.toString().trim());
    }

    @Test
    public void MageTestDefend() {
        Mage mage = new Mage();
        Character mageCharacter = new MageAdapter(mage);
        mageCharacter.defend();
        assertEquals("Mage cannot defend directly - relies on spells", outputStream.toString().trim());
    }

    @Test
    public void BardTestMove() {
        Bard bard = new Bard();
        Character bardCharacter = new BardAdapter(bard);
        bardCharacter.move();
        assertEquals("Bard cannot move during performance", outputStream.toString().trim());
    }

    @Test
    public void BardTestAttack() {
        Bard bard = new Bard();
        Character bardCharacter = new BardAdapter(bard);
        bardCharacter.attack();
        assertEquals("Bard is annoying with his nasty voice", outputStream.toString().trim());
    }
    @Test
    public void BardTestDefend() {
        Bard bard = new Bard();
        Character bardCharacter = new BardAdapter(bard);
        bardCharacter.defend();
        assertEquals("Bard is playing something romantic...", outputStream.toString().trim());
    }

    @Test
    public void AssassinTestMove() {
        Assassin assassin = new Assassin();
        Character assassinCharacter = new AssassinAdapter(assassin);
        assassinCharacter.move();
        assertEquals("Assassin disappears into the shadows", outputStream.toString().trim());
    }

    @Test
    public void AssassinTestAttack() {
        Assassin assassin = new Assassin();
        Character assassinCharacter = new AssassinAdapter(assassin);
        assassinCharacter.attack();
        assertEquals("Assassin applies poison to weapons", outputStream.toString().trim());
    }

    @Test
    public void AssassinTestDefend() {
        Assassin assassin = new Assassin();
        Character assassinCharacter = new AssassinAdapter(assassin);
        assassinCharacter.defend();
        assertEquals("Assassin relies on evasion and stealth", outputStream.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standartOut);
    }
}

import org.example.ParserStrategy;
import org.junit.jupiter.api.Test;


import org.example.ParserOfLetters;
import org.example.ParserOfDigits;
import org.example.ParserOfLettersAndDigits;


import static org.junit.jupiter.api.Assertions.*;

public class ParserTests {
    @Test
    public void LettersTestSuccess() {
        ParserStrategy parser = new ParserOfLetters();
        assertEquals("Какойтотекст", parser.parse("Какой-то текст"));
    }

    @Test
    public void LettersTestSpecSymbols() {
        ParserStrategy parser = new ParserOfLetters();
        assertEquals("", parser.parse("\n\t\"\\"));
    }

    @Test
    public void LettersTestEmpty() throws RuntimeException {
        ParserStrategy parser = new ParserOfLetters();
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> parser.parse(""), "Expected exception");

        assertTrue(exception.getMessage().contains("Inputline is empty"));
    }

    @Test
    public void DigitsTestSuccess() {
        ParserStrategy parser = new ParserOfDigits();
        assertEquals("12", parser.parse("Какой-то текст12"));
    }

    @Test
    public void DigitsTestSpecSymbols() {
        ParserStrategy parser = new ParserOfDigits();
        assertEquals("", parser.parse("\n\t\"\\"));
    }

    @Test
    public void DigitsTestEmpty() {
        ParserStrategy parser = new ParserOfDigits();
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> parser.parse(""), "Expected exception");

        assertTrue(exception.getMessage().contains("Inputline is empty"));
    }

    @Test
    public void LettersAndDigitsTestSuccess() {
        ParserStrategy parser = new ParserOfLettersAndDigits();
        assertEquals("Какойтотекст12", parser.parse("Какой-то текст12"));
    }

    @Test
    public void LettersAndDigitsTestSpecSymbols() {
        ParserStrategy parser = new ParserOfLettersAndDigits();
        assertEquals("", parser.parse("\n\t\"\\"));
    }

    @Test
    public void LettersAndDigitsTestEmpty() {
        ParserStrategy parser = new ParserOfLettersAndDigits();
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> parser.parse(""), "Expected exception");

        assertTrue(exception.getMessage().contains("Inputline is empty"));
    }
}

import org.junit.jupiter.api.Test;

import org.example.AbstractParser;
import org.example.ParserOfLetters;
import org.example.LettersParser;
import org.example.ParserOfDigits;
import org.example.DigitsParser;
import org.example.ParserOfLettersAndDigits;
import org.example.LettersAndDigitsParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTests
{
    @Test
    public void LettersTestSuccess()
    {
        AbstractParser parser = new LettersParser(new ParserOfLetters());
        assertEquals("Какойтотекст", parser.parse("Какой-то текст"));
    }

    @Test
    public void LettersTestFail()
    {
        AbstractParser parser = new LettersParser(new ParserOfLetters());
        assertEquals("Какойтотекст1", parser.parse("Какой-то текст1"));
    }

    @Test
    public void DigitsTestSuccess()
    {
        AbstractParser parser = new DigitsParser(new ParserOfDigits());
        assertEquals("12", parser.parse("Какой-то текст12"));
    }

    @Test
    public void DigitsTestFail()
    {
        AbstractParser parser = new DigitsParser(new ParserOfDigits());
        assertEquals("Какойтотекст12", parser.parse("Какой-то текст12"));
    }

    @Test
    public void LettersAndDigitsTestSuccess()
    {
        AbstractParser parser = new LettersAndDigitsParser(new ParserOfLettersAndDigits());
        assertEquals("Какойтотекст12", parser.parse("Какой-то текст12"));
    }

    @Test
    public void LettersAndDigitsTestFail()
    {
        AbstractParser parser = new LettersAndDigitsParser(new ParserOfLettersAndDigits());
        assertEquals("Какой-то текст1", parser.parse("Какой-то текст1"));
    }
}

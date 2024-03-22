package org.example;

public class ParserOfLettersAndDigits implements ParserStrategy
{
    public String parse(String inputLine)
    {
        StringBuilder outputLine = new StringBuilder();
        for (char symbol : inputLine.toCharArray())
        {
            if (Character.isLetter(symbol) || Character.isDigit(symbol))
            {
                outputLine.append(symbol);
            }
        }
        return outputLine.toString();
    }
}

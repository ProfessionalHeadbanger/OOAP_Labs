package org.example;

public class ParserOfLetters implements ParserStrategy
{
    public String parse(String inputLine)
    {
        StringBuilder outputLine = new StringBuilder();
        for (char symbol : inputLine.toCharArray())
        {
            if (Character.isLetter(symbol))
            {
                outputLine.append(symbol);
            }
        }
        return outputLine.toString();
    }
}
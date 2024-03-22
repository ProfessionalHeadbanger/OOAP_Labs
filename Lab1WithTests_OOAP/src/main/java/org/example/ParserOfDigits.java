package org.example;

public class ParserOfDigits implements ParserStrategy
{
    public String parse(String inputLine)
    {
        StringBuilder outputLine = new StringBuilder();
        for (char symbol : inputLine.toCharArray())
        {
            if (Character.isDigit(symbol))
            {
                outputLine.append(symbol);
            }
        }
        return outputLine.toString();
    }
}

package org.example;

public class ParserOfLetters implements ParserStrategy
{
    public String parse(String inputLine)
    {
        if (inputLine.isBlank()) throw new RuntimeException("Inputline is empty");
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

    @Override
    public void printAlgorithmName() {
        System.out.println("Парсер букв");
    }

    @Override
    public void printAlgorithmDescription() {
        System.out.println("Парсер в этом режиме считывает только буквы из приведенного файла.");
    }
}
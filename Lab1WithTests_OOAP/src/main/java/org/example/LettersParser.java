package org.example;

public class LettersParser extends AbstractParser
{
    public LettersParser(ParserStrategy strategy)
    {
        super(strategy);
    }

    @Override
    protected void printAlgorithmName() {
        System.out.println("Парсер букв");
    }

    @Override
    protected void printAlgorithmDescription() {
        System.out.println("Парсер в этом режиме считывает только буквы из приведенного файла.");
    }
}

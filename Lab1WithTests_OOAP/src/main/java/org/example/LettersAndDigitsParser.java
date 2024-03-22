package org.example;

public class LettersAndDigitsParser extends AbstractParser
{
    public LettersAndDigitsParser(ParserStrategy strategy)
    {
        super(strategy);
    }

    @Override
    protected void printAlgorithmName() {
        System.out.println("Парсер букв и цифр");
    }

    @Override
    protected void printAlgorithmDescription() {
        System.out.println("Парсер в этом режиме считывает и буквы, и цифры из приведенного файла.");
    }
}

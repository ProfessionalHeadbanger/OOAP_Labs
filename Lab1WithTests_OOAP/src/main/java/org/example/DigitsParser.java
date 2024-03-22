package org.example;

public class DigitsParser extends AbstractParser
{
    public DigitsParser(ParserStrategy strategy)
    {
        super(strategy);
    }

    @Override
    protected void printAlgorithmName() {
        System.out.println("Парсер цифр");
    }

    @Override
    protected void printAlgorithmDescription() {
        System.out.println("Парсер в этом режиме считывает только цифры из приведенного файла.");
    }
}

package org.example;

public abstract class AbstractParser
{
    protected ParserStrategy strategy;

    public AbstractParser(ParserStrategy strategy)
    {
        this.strategy = strategy;
    }

    public void execute(String inputLine) {
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        printAlgorithmName();
        printAlgorithmDescription();
        printExecutionTime(executionTime);
        System.out.println("Результат парсинга: " + parse(inputLine));
    }

    public String parse(String inputLine)
    {
        return strategy.parse(inputLine);
    }

    protected abstract void printAlgorithmName();

    protected abstract void printAlgorithmDescription();

    protected void printExecutionTime(long time) {
        System.out.println("Время выполнения алгоритма: " + time + " миллисекунд.");
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

interface ParserStrategy
{
    String parse(String inputline);
}

abstract class AbstractParser
{
    protected ParserStrategy strategy;

    public AbstractParser(ParserStrategy strategy)
    {
        this.strategy = strategy;
    }

    public void execute(String inputline) {
        long startTime = System.currentTimeMillis();
        String result = strategy.parse(inputline);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        printAlgorithmName();
        printAlgorithmDescription();
        printExecutionTime(executionTime);
        System.out.println("Результат парсинга: " + result);
    }

    protected abstract void printAlgorithmName();

    protected abstract void printAlgorithmDescription();

    protected void printExecutionTime(long time) {
        System.out.println("Время выполнения алгоритма: " + time + " миллисекунд.");
    }
}

class ParserOfLetters implements ParserStrategy
{
    public String parse(String inputline)
    {
        StringBuilder outputline = new StringBuilder();
        for (char symbol : inputline.toCharArray())
        {
            if (Character.isLetter(symbol))
            {
                outputline.append(symbol);
            }
        }
        return outputline.toString();
    }
}

class LettersParser extends AbstractParser
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

class ParserOfDigits implements ParserStrategy
{
    public String parse(String inputline)
    {
        StringBuilder outputline = new StringBuilder();
        for (char symbol : inputline.toCharArray())
        {
            if (Character.isDigit(symbol))
            {
                outputline.append(symbol);
            }
        }
        return outputline.toString();
    }
}

class DigitsParser extends AbstractParser
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

class ParserOfLettersAndDigits implements ParserStrategy
{
    public String parse(String inputline)
    {
        StringBuilder outputline = new StringBuilder();
        for (char symbol : inputline.toCharArray())
        {
            if (Character.isLetter(symbol) || Character.isDigit(symbol))
            {
                outputline.append(symbol);
            }
        }
        return outputline.toString();
    }
}

class LettersAndDigitsParser extends AbstractParser
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

public class Main
{
    public static void main(String[] args)
    {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла: ");
        String filename = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            StringBuilder inputtext = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
            {
                inputtext.append(line);
            }

            String inputline = inputtext.toString();

            System.out.println("Выберите режим работы парсера:");
            System.out.println("1. Только буквы;");
            System.out.println("2. Только цифры;");
            System.out.println("3. Буквы и цифры.");
            int choice = scanner.nextInt();

            AbstractParser parser;
            switch (choice)
            {
                case 1:
                    parser = new LettersParser(new ParserOfLetters());
                    break;
                case 2:
                    parser = new DigitsParser(new ParserOfDigits());
                    break;
                case 3:
                    parser = new LettersAndDigitsParser(new ParserOfLettersAndDigits());
                    break;
                default:
                    System.out.println("Неправильный ввод");
                    return;
            }

            parser.execute(inputline);
        }
        catch (IOException error)
        {
            error.printStackTrace();
        }
    }
}
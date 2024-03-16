import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

interface ParserStrategy
{
    String parse(String inputline);
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

class Parser
{
    private ParserStrategy strategy;

    public Parser(ParserStrategy strategy)
    {
        this.strategy = strategy;
    }

    public String parse(String inputline)
    {
        return strategy.parse(inputline);
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

            Parser parser;
            switch (choice)
            {
                case 1:
                    parser = new Parser(new ParserOfLetters());
                    break;
                case 2:
                    parser = new Parser(new ParserOfDigits());
                    break;
                case 3:
                    parser = new Parser(new ParserOfLettersAndDigits());
                    break;
                default:
                    System.out.println("Неправильный ввод");
                    return;
            }

            System.out.println("Результат парсинга из файла " + filename + " : " + parser.parse(inputline));
        }
        catch (IOException error)
        {
            error.printStackTrace();
        }
    }
}
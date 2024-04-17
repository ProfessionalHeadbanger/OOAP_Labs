package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
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

            ParserStrategy parser;
            switch (choice)
            {
                case 1:
                    parser = new ParserOfLetters();
                    break;
                case 2:
                    parser = new ParserOfDigits();
                    break;
                case 3:
                    parser = new ParserOfLettersAndDigits();
                    break;
                default:
                    System.out.println("Неправильный ввод");
                    return;
            }

            parser.printAlgorithmName();
            parser.printAlgorithmDescription();
            long startTime = System.currentTimeMillis();
            System.out.println("Результат парсинга: " + parser.parse(inputline));
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            System.out.println("Время выполнения алгоритма: " + executionTime + " миллисекунд.");
        }
        catch (IOException error)
        {
            error.printStackTrace();
        }
    }
}
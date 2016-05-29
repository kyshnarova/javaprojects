import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Kyshnarova Nastia
 */
public class Fibonacci {
    private static final String INPUT_FILE_PATH = "./input.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Please, enter Your choice '1'(read from file) or '2'(exit)");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                String stringLineFromFile = ReadFromFile(INPUT_FILE_PATH);
                List<Integer> intArrayFromFile;

                try {
                    intArrayFromFile = ConvertStringToInt(stringLineFromFile);
                } catch (NumberFormatException ex) {
                    System.out.println("Please enter correct data!");
                    continue;
                }

                printIntegerLine(intArrayFromFile);
                Fibonacci(intArrayFromFile);

            } else if (choice.equals("2")) {
                System.out.println("Bye! We close this program!");
                break;
            }
        }

    }

    public static String ReadFromFile(String pathToFile) {
        String lineFromFile = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
            lineFromFile = reader.readLine();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + pathToFile);
        } catch (IOException e) {
            System.err.println("IOException happens during reading from a file: " + pathToFile);
        }

        return lineFromFile;
    }

    public static List<Integer> ConvertStringToInt(String lineForConvert) {
        String[] stringArray = lineForConvert.split(" ");
        List<Integer> integerList = new ArrayList<Integer>();

        for (int i = 0; i < stringArray.length; i++) {
            integerList.add(Integer.parseInt(stringArray[i]));
        }
        return integerList;
    }

    private static void printIntegerLine(List<Integer> list) {
        System.out.println("intArray in File");
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(list.get(list.size() - 1));
    }

    public static void Fibonacci(List<Integer> intArrayForFibonacci) {
        int b = 0;
        int x = (intArrayForFibonacci.size() - 2); //Это необходимо для конечной проверки является ли ряд Фибоначчи.
        for (int i = 0; i < (intArrayForFibonacci.size() - 2); i++) {
            if (intArrayForFibonacci.get(i) + intArrayForFibonacci.get(i + 1) == intArrayForFibonacci.get(i + 2)) {
                b++;
                System.out.println("Step " + b);
                System.out.println(intArrayForFibonacci.get(i) + " + " + intArrayForFibonacci.get(i + 1) + " = " + intArrayForFibonacci.get(i + 2) + " is " + (intArrayForFibonacci.get(i) + intArrayForFibonacci.get(i + 1) == intArrayForFibonacci.get(i + 2)));
            } else {
                System.out.println("This step will show you where is a problem:");
                System.out.println(intArrayForFibonacci.get(i) + " + " + intArrayForFibonacci.get(i + 1) + " = " + intArrayForFibonacci.get(i + 2) + " is " + (intArrayForFibonacci.get(i) + intArrayForFibonacci.get(i + 1) == intArrayForFibonacci.get(i + 2)));
            }
        }
        if (b == x) {
            System.out.println("Congratulations! You have Fibonacci sequence! ");

        } else {
            System.out.println("Sorry! But it's not Fibonacci sequence");

        }
    }


}
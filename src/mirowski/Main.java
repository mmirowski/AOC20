package mirowski;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int result = prepareExpenseReport();
        System.out.println(result);
    }

    private static int prepareExpenseReport() {
        final String PATH_TO_EXPENSES_FILE = "src/mirowski/input/expenses.txt";
        List<Integer> expenses = new ArrayList<>();
        readData(PATH_TO_EXPENSES_FILE, expenses);
        return getMultiplicationResultForThreeNumbers(expenses);
    }

    private static void readData(String pathToFile, List<Integer> expenses) {
        try {
            FileReader fileReader = new FileReader(pathToFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while (line != null) {
                int val = Integer.parseInt(line);
                expenses.add(val);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading lines from the file.");
            e.printStackTrace();
        }
    }

    private static int getMultiplicationResultForTwoNumbers(List<Integer> expenses) {
        final int EXPENSES_SUM = 2020;

        for (int i = 0; i < expenses.size(); i++) {
            int firstValue = expenses.get(i);

            for (int j = 0; j < expenses.size(); j++) {
                int secondValue = expenses.get(j);

                if (firstValue + secondValue == EXPENSES_SUM) {
                    return firstValue * secondValue;
                }
            }
        }

        return -1;
    }

    private static int getMultiplicationResultForThreeNumbers(List<Integer> expenses) {
        final int EXPENSES_SUM = 2020;

        for (int i = 0; i < expenses.size(); i++) {
            int firstValue = expenses.get(i);

            for (int j = 0; j < expenses.size(); j++) {
                int secondValue = expenses.get(j);

                for (int thirdValue : expenses) {
                    if (firstValue + secondValue + thirdValue == EXPENSES_SUM) {
                        return firstValue * secondValue * thirdValue;
                    }
                }
            }
        }

        return -1;
    }
}
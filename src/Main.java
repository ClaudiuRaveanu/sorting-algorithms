import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String ... args) {

        /**
         * Change array dimension based on the size of the list you want to sort
         */
        int[] list = new int[1000000];

        try {
            /**
             * Name of the file which contains the list you want to sort
             */
            Scanner scanner = new Scanner(new File("src/1000000_sorted_list.txt"));
            int i = 0;

            while (scanner.hasNextInt())
                list[i++] = scanner.nextInt();

            long start = System.currentTimeMillis();
            SelectionSort.sort(list);
            long end = System.currentTimeMillis();

            /**
             * Change the name of the output file based on your preferrence
             */
            FileWriter file = new FileWriter("million.txt");

            /**
             * Change the value j can go to based on your preferrence
             * (it is recommended to be the max value the list contains for better results)
             */
            for (int j = 0; j < 1000000; j++)
                file.write(Integer.toString(list[j]) + '\n');

            file.close();

            /**
             * Elapsed time (in milliseconds) of the sorting algorithm's execution
             */
            System.out.println("Elapsed time: " + (end - start) + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

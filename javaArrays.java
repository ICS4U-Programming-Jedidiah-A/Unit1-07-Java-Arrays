import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
* The program will read and output to text files.
*
* @author  Jedidiah Alfred
* @version 1.0
* @since   2023-03-21
*/

public final class javaArrays {
    /**
    * For style checkers.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private javaArrays() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print messages.
    *
    * @param args Unused
    */
    public static void main(String[] args) throws Exception {

        // Declare the list
        final ArrayList<String> numList = new ArrayList<String>();
        try {

            // This will write the input in a file of it's choice.
            // Then write the file name.
            final File input = new File("Unit1-07-set3.txt");
            final Scanner inputScanner = new Scanner(input);

            // Choose a file to print the output.
            final FileWriter output = new FileWriter("output.txt");
            while (inputScanner.hasNextLine()) {

                // Add next line
                numList.add(inputScanner.nextLine());
            }

            // Creating an array with the same elements.
            final int[] numArr = new int[numList.size()];
            for (int location = 0; location < numArr.length; location++) {
                numArr[location] = Integer.parseInt(numList.get(location));
            }

            // Sort the functions
            Arrays.sort(numArr);

            // Function call
            final double mean = mean(numArr);
            final double median = median(numArr);

            // Print the results
            System.out.println("mean: " + mean);
            System.out.println("median: " + median);

            // Close writer.
            output.close();
        } catch (IOException error) {

            // For when no input file is found.
            System.err.println("Error: " + error.getMessage());
        }
    }
    /**
    * This calculates the mean.
    *
    * @param numbers In array
    * @return mean
    */

    public static double mean(int[]numbers) {

        // Declares variables for function
        double mean = 0;
        double sumUp = 0;
        final double length = numbers.length;
        for (int position = 0; position < length; position = position + 1) {
            sumUp = sumUp + numbers[position];
        }
        mean = sumUp / length;
        return mean;
    }
    /**
    * This function does the calculation
    *
    * @param numbers of inputs
    * @return function outputs
    */


    public static double median(int[]numbers) {

        // Declares variables.
        double median = 0;

        final int length = numbers.length;
        if (length % 2 == 0) {
            median = (numbers[length / 2]
                      + numbers[length / 2 - 1]) / 2;
        } else {
            final int mid = (int) Math.floor(length / 2);
            median = numbers[mid];
        }
        // This returns median 
        return median;
    }
}

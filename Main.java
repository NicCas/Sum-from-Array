import java.util.Arrays;
import java.util.Random;

public class Main {
    static final int [] sizes = {100, 1000, 100000, 1000000};
    static int [] myArray = {};

    public static void main(String[] args)
    {
        Random rand = new Random();
        BruteForce bf = new BruteForce(myArray);

        BinarySearch DAC = new BinarySearch(myArray);

        int[] sumArray;

        int sum = rand.nextInt(401) - 200;

        long startTime;
        long elapsedTime;

        for (int j = 0; j < 1; j++)
        {
            // Create Array
            myArray = new int[sizes[j]];

            System.out.println("Creating randomized array.....");

            for (int i = 0; i < sizes[j]; i++) {
                myArray[i] = rand.nextInt(201) - 100;
            }

            System.out.println(Arrays.toString(myArray));
            System.out.println();

            // Unsorted Sums
            bf = new BruteForce(myArray);

            System.out.print("Starting unsorted brute force attempt.....            ");
            startTime = System.currentTimeMillis();
            sumArray = bf.bFMethod(sum);
            elapsedTime = System.currentTimeMillis() - startTime;

            if (sumArray == null)
                System.out.println("No addends found for " + sum + ". Unsorted Brute Force Time: "+ elapsedTime + " ms");
            else
                System.out.println("The sum of " + Arrays.toString(sumArray) + " equals " + sum + ". Unsorted Brute Force Time: "+ elapsedTime + " ms");

            DAC = new BinarySearch(myArray);

            System.out.print("Starting unsorted divide and conquer attempt.....     ");
            startTime = System.currentTimeMillis();
            sumArray = DAC.searchSum(sum);
            elapsedTime = System.currentTimeMillis() - startTime;

            if (sumArray == null)
                System.out.println("No addends found for " + sum + ". Unsorted Divide and Conquer Time:  "+ elapsedTime + " ms");
            else
                System.out.println("The sum of " + Arrays.toString(sumArray) + " equals " + sum + ". Unsorted Divide and Conquer Time: "+ elapsedTime + " ms");

            // Sorting Array
            System.out.println("Starting array sort.....");
            quickSort(0, sizes[j]-1);

            // Sorted Sums
            bf = new BruteForce(myArray);

            System.out.print("Starting sorted brute force attempt.....              ");
            startTime = System.currentTimeMillis();
            sumArray = bf.bFMethod(sum);
            elapsedTime = System.currentTimeMillis() - startTime;

            if (sumArray == null)
                System.out.println("No addends found for " + sum + ". Sorted Brute Force Time:  "+ elapsedTime + " ms");
            else
                System.out.println("The sum of " + Arrays.toString(sumArray) + " equals " + sum + ". Sorted Brute Force Time: "+ elapsedTime + " ms");

            DAC = new BinarySearch(myArray);

            System.out.print("Starting sorted divide and conquer attempt.....       ");
            startTime = System.currentTimeMillis();
            sumArray = DAC.searchSum(sum);
            elapsedTime = System.currentTimeMillis() - startTime;

            if (sumArray == null)
                System.out.println("No addends found for " + sum + ". Sorted Divide and Conquer Time:  "+ elapsedTime + " ms");
            else
                System.out.println("The sum of " + Arrays.toString(sumArray) + " equals " + sum + ". Sorted Divide and Conquer Time: "+ elapsedTime + " ms");
        }
    }

    static void quickSort(int low, int high){
        if (low < high){
            int index = separate(low, high);

            quickSort(low, index-1);
            quickSort(index+1, high);

        }
    }

    static int separate(int low, int high)
    {
        int pi = myArray[high];
        int index = low -1;
        for (int i = low; i < high - 1; i++) {
            if(myArray[i] < pi) {
                index++;

                int temp = myArray[index];
                myArray[index] = myArray[i];
                myArray[i] = temp;
            }
        }
        int temp = myArray[index + 1];
        myArray[index + 1] = myArray[high];
        myArray[high] = temp;

        return index + 1;
    }
}

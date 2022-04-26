import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
public class Blatt3 {
    public static void main(String[] args) {
        String input0 = args[0];
        try
        {
           int k = Integer.parseInt(input0) ;
        }
        catch (NumberFormatException e)
        {
            System.out.println(input0 + " is not a valid integer");
            System.exit(1);
        }

        Scanner input = new Scanner(System.in);
        ArrayList data = new ArrayList<Integer>();
        try {
            while (input.hasNextLine()) {
                data.add(Integer.parseInt(input.nextLine()));
            }

            int[] Array = new int[data.size()];
            for (int i = 0; i < data.size(); i++) {
                Array[i] = (int) data.get(i);
            }
            Arrays.sort(Array );
            System.out.println("Before removing duplicates: "+java.util.Arrays.toString(Array));
            removeDuplicates (Array) ;
            System.out.println("After removing duplicates: "+java.util.Arrays.toString(Array));
            int k = Integer.parseInt(input0) ;
            int n = Array.length ;
            if (k > n)
            { System.out.println("K is too large") ;
            }
             else { printCombination(Array, n, k);
                int x = (factorial(Array.length)/((factorial(Array.length-k))*factorial(k))) ;
                System.out.println("there are "+ x + " subsets");

            }
        } catch (NumberFormatException e) {

            System.out.println("Something went wrong");
        }

    }
    public static int removeDuplicates(int arr[])
    { int n= arr.length ;
        // if(array size if 0 or 1 array is already sorted)
        if (n == 0 || n == 1) {
            return n;
        }
        int j = 0;
        // check if the ith element is not equal to
        // the (i+1)th element, then add that element
        // at the jth index in the same array
        // which indicates that te particular element
        // will only be added once in the array
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[j++] = arr[i];
            }
        }

        arr[j++] = arr[n - 1];

        return j;
    }

        /* arr[] ---> Input Array
        data[] ---> Temporary array to store current combination
        start & end ---> Starting and Ending indexes in arr[]
        index ---> Current index in data[]
        r ---> Size of a combination to be printed */
        static void combinationUtil(int arr[], int n, int r,
                                    int index, int data[], int i)
        {
            // Current combination is ready to be printed,
            // print it
            if (index == r) {
                for (int j = 0; j < r; j++)
                    System.out.print(data[j] + " ");
                System.out.println("");
                return;
            }

            // When no more elements are there to put in data[]
            if (i >= n)
                return;

            // current is included, put next at next
            // location
            data[index] = arr[i];
            combinationUtil(arr, n, r, index + 1,
                    data, i + 1);

            // current is excluded, replace it with
            // next (Note that i+1 is passed, but
            // index is not changed)
            combinationUtil(arr, n, r, index, data, i + 1);
        }

        // The main function that prints all combinations
        // of size r in arr[] of size n. This function
        // mainly uses combinationUtil()
        public static void printCombination(int arr[], int n, int r)
        {
            // A temporary array to store all combination
            // one by one
            int data[] = new int[r];

            // Print all combination using temporary
            // array 'data[]'
            combinationUtil(arr, n, r, 0, data, 0);
        }

        /* Driver function to check for above function */

        public static int factorial(int n){
            if (n == 1)
                return 1;
            else
                return(n * factorial(n-1));
        }
    }




import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
public class LexPermute {
    public static void main(String[] args) {
        String input0 = args[0];
        try {
            int k = Integer.parseInt(input0);
        } catch (NumberFormatException e) {
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
            Arrays.sort(Array);
            int k = Integer.parseInt(input0);
            perm(Array, k);
        }catch (NumberFormatException e) {

            System.out.println("Something went wrong");
        }
    }
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean hasNext(int[] a) {
        int n = a.length;
        // find rightmost element a[k] that is smaller than element to its right
        int k;
        for (k = n-2; k >= 0; k--)
            if (a[k] < a[k+1]) break;
        if (k == -1) return false;

        // find rightmost element a[j] that is larger than a[k]
        int j = n-1;
        while (a[k] > a[j])
            j--;
        swap(a, j, k);

        for (int r = n-1, s = k+1; r > s; r--, s++)
            swap(a, r, s);
        return true;
    }

    public static void perm(int[] arr, int n) {

        System.out.println("Sorted input:");
        System.out.println(java.util.Arrays.toString(arr));
        System.out.println("The "+n+"-smallest permutation is:");
        if(n==1)
            System.out.println(java.util.Arrays.toString(arr));
        else {
            int i = 2;
            while (hasNext(arr) && i < n) {
                i++;
            }
            System.out.println(java.util.Arrays.toString(arr));
        }
    }
}
package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SwapAlternate {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int size = sc.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j += 2) {
                if (j + 1 >= size) {
                    arr[j] = sc.nextInt();
                    break;
                }
                int temp = sc.nextInt();
                arr[j + 1] = temp;
                arr[j] = sc.nextInt();
                // if (j == 0) {

                // }
            }
            System.out.println(Arrays.toString(arr));

        }
        sc.close();
    }
}

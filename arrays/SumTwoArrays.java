package arrays;

import java.util.Arrays;

public class SumTwoArrays {
    public static void main(String[] args) {
        int a[] = new int[] { 4, 5, 1 };
        int n = a.length;
        int b[] = new int[] { 3, 4, 5 };
        int m = b.length;
        System.out.println(Arrays.toString(findArraySum(a, n, b, m)));
    }

    public static int[] findArraySum(int[] a, int n, int[] b, int m) {
        // Write your code here.
        int resSize = Math.max(m, n);
        int result[] = new int[resSize + 1];
        while (n > 0 && m > 0) {
            n--;
            m--;
            int temp = a[n] + b[m] + result[resSize];
            if (temp > 9) {
                result[resSize] = temp % 10;
                result[resSize - 1] = 1;
            } else {
                result[resSize] = temp;
            }
            resSize--;
        }
        while (n > 0) {
            n--;
            int temp = a[n] + result[resSize];
            if (temp > 9) {
                result[resSize] = temp % 10;
                result[resSize - 1] = 1;
            } else {
                result[resSize] = temp;
            }
            resSize--;
        }
        while (m > 0) {
            m--;
            int temp = b[m] + result[resSize];
            if (temp > 9) {
                result[resSize] = temp % 10;
                result[resSize - 1] = 1;
            } else {
                result[resSize] = temp;
            }
            resSize--;
        }
        // System.out.println("copy" + Arrays.toString(Arrays.copyOfRange(result, 1,
        // resSize + 1)));
        // System.out.println("copy" + Arrays.toString(result));
        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        }
        return result;
    }
}

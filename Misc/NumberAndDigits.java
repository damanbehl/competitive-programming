//https://www.codingninjas.com/codestudio/problems/number-and-digits_975269
package Misc;

import java.util.ArrayList;
import java.util.Collections;

public class NumberAndDigits {
    public static void main(String[] args) {
        ArrayList<Integer> al = numbersAndDigits(5512);
        if (al.size() == 0) {
            System.out.println(-1);
        } else {
            for (int x : al) {
                System.out.print(x + " ");
            }
        }
    }

    // public static ArrayList<Integer> numbersAndDigits(int i) {
    // ArrayList<Integer> al = new ArrayList<Integer>();
    // for (int n = 1; n < i; n++) {
    // int sum = sumDigitsAndNumberRecursive(n) + n;
    // if (sum > i) {
    // break;
    // } else if (sum == i) {
    // al.add(n);
    // }
    // }
    // return al;
    // // Write your code here
    // }
    /**
     * sum of digits cannot be too high, so the range of numbers that fit the
     * criteria is reduced greatly
     * eg 5512, subtract 1000 = 4412, so even for 4999 sum is 31+4999= 5030 and
     * (triple 9 is the most sum we can have without exceeding the acc number)
     * numbers who sum will be equal to number will be closer to the actual number
     * like
     * 5501, 5492
     * 
     */

    public static ArrayList<Integer> numbersAndDigits(int i) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int n = 1; n < 1001; n++) {
            int leftPointer = i - n;
            int sum = sumDigitsAndNumberRecursive(leftPointer) + leftPointer;
            if (leftPointer >= 1 && sum == i) {
                al.add(leftPointer);
            }
        }
        if (al.size() == 0) {
            al.add(-1);
        }
        Collections.sort(al);
        return al;
        // Write your code here
    }

    static int sumDigitsAndNumberRecursive(int x) {
        if (x == 0) {
            return 0;
        }
        return x % 10 + sumDigitsAndNumberRecursive(x / 10);
    }

    static int sumDigitsAndNumber(int x) {
        // System.out.println("in for x=" + x);
        int sum = 0;
        while (x > 0) {
            sum = sum + x % 10;
            x = x / 10;
        }
        return sum;
    }
}

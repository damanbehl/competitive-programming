package Algorithms;

import java.util.Arrays;

public class ExtendedEuclidean {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(gcdExtended(81, 57)));
    }

    static int[] gcdExtended(int a, int b) {
        if (b == 0) {
            return new int[] { a, 1, 0 };
        }
        int gcd[] = gcdExtended(b, a % b);
        int x1 = gcd[1];
        int y1 = gcd[2];
        int x = y1;
        int y = x1 - ((a / b) * y1);
        return new int[] { gcd[0], x, y };
    }
}

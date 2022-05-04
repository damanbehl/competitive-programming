/**
 * solved to :https://open.spotify.com/track/5UatawMsGULDVG2h8wE1KS?si=e6b6ac6265ca4e62
 * https://practice.geeksforgeeks.org/problems/modular-multiplicative-inverse-1587115620
 * solution for (a/b)%m
 */
package Maths;

public class MMIExtendedEuc {
    public static void main(String[] args) {
        int a = 334;
        int b = 123;
        int m = 5;
        System.out.println("result of mod inv of b=" + b + "  under mod=" + m + " is> " + +getModInverse(b, m));
        System.out.println("result of mod divison of " + a + "/" + b + " under m=" + m + " is > " + modDivide(a, b, m));
    }

    /**
     * This function calculates(a/b)%m
     * by finding b^(-1) under mod m
     */
    static int modDivide(int a, int b, int m) {
        a = a % m;
        int bInvModm = getModInverse(b, m);
        if (bInvModm == -1) {
            System.out.println("inverse does not exist for m");
            return bInvModm;
        }
        return (a * bInvModm) % m;
    }

    static int getModInverse(int a, int m) {
        if (a % m == 0) {
            return -1;
        }
        int gcd[] = gcdExtended(a, m);
        if (gcd[0] != 1)
            return -1;
        else
            return (gcd[1] % m + m) % m;
    }

    static int[] gcdExtended(int a, int b) {
        if (b == 0) {
            int x = 1;
            int y = 0;
            return new int[] { a, x, y };
        }
        int gcd[] = gcdExtended(b, a % b);
        int d = gcd[0], x1 = gcd[1], y1 = gcd[2];
        int x = y1;
        int y = x1 - ((a / b) * y1);
        return new int[] { d, x, y };
    }
}

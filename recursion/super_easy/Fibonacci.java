/**
 * https://practice.geeksforgeeks.org/problems/nth-fibonacci-number1335
 */
package recursion.super_easy;

public class Fibonacci {
    static int modulo = 1000000007;

    public static void main(String[] args) {
        System.out.println(fibonacciNumberSol(9485));
    }

    public static long fib(long n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return (fib(n - 1) % modulo + fib(n - 2) % modulo) % modulo;
    }

    // gfg
    static long nthFibonacci(long n) {
        long mod = 1000000007;
        long a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % mod;
            a = b;
            b = c;
        }
        return b;
    }

    /**
     * recursive call are more expensive then iterations in java
     * because each time a new stack frame is inserted which is costly in context to
     * time
     */
    public static int fibonacciNumber(int n) {
        int m = 1000000007;
        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = (a % m + b % m) % m;
            a = b;
            b = c;
        }
        return b;
    }

    public static int fibMemo(int n, int arr[]) {
        if (n < 0) {
            System.out.println("gone negative");
            System.exit(0);
        }
        if (n == 0 || n == 1) {
            return arr[n];
        }
        if (arr[n - 1] != 0) {
            return arr[n - 1];
        }
        int nth = (fibMemo(n - 1, arr) % modulo + fibMemo(n - 2, arr) % modulo) % modulo;
        // int nth = (fibMemo(n - 1, hm) + fibMemo(n - 2, hm)) % modulo;
        arr[n - 1] = nth;
        return nth;
    }

    // memoization
    public static int fibonacciMemoNumber(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int arr[] = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        return fibMemo(n, arr);
    }

    static int fibonacciNumberSol(int n) {
        int mod = (int) 1e9 + 7;
        int a = 0;
        int b = 1;
        int c;
        for (int i = 2; i <= n; i++) {
            // The variable c stores the ith Fibonacci Number.
            c = (a + b) % mod;
            // Updating values of a and b.
            a = b;
            b = c;
        }
        // The variable b stores the nth Fibonacci Number.
        return b;
    }

    // public static int hailMary(int n) {
    // int arr[] = new int[n];
    // arr[0] = 0;
    // arr[1] = 1;
    // }
}

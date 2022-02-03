package Maths;

/**
 * https://www.codechef.com/problems/DIVREC
 */
import java.util.Scanner;

public class DivisorsNReciprocals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long x = sc.nextInt();
            long a = sc.nextInt();
            long b = sc.nextInt();
            if ((x * b) % a != 0 || a < b) {
                System.out.println(-1);
                continue;
            }
            long n = (x * b) / a;
            long sumdiv = getSumDivisors(n);
            if (sumdiv == x) {
                System.out.println(n);
            } else {
                System.out.println(-1);
            }
        }
    }

    static long getSumDivisors(long x) {
        long sum = 0;
        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                if (x / i == i) {
                    sum += i;
                } else {
                    sum = sum + (x / i) + i;
                }
            }
        }
        return sum;
    }
}

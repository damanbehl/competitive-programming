/**
 * Fermat's little theorem only for a^(m-1) congurent to 1 mod P where P is prime and GCD(a,P) == 1
 */

package Maths;

import java.util.Scanner;

public class MultiplicativeModuloInverse {
    public static void main(String[] args) {
        int t, a, b, m;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            a = sc.nextInt();
            m = sc.nextInt();
            System.out.println("a^-1 = " + power(a, m - 2, m));
        }
    }

    static int power(int a, int n, int m) {
        int res = 1;
        a = a % m;
        if (a == 0) {
            return -1;
        }
        while (n > 0) {
            if ((n & 1) != 0) {
                res = (res * a) % m;
            }
            // now n must be even and halved
            n = n >> 1; // n = n/2
            a = (a * a) % m;
        }
        return res;
    }

}

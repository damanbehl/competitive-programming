package recursion.super_easy;

public class XToThePower {
    public static void main(String[] args) {
        System.out.println(powBetter(2, 5));
    }

    public static long pow(int x, int n) {
        if (n == 1) {
            return x;
        }
        return x * pow(x, n - 1);
    }

    /**
     * time complexity o(logy)
     */
    static long powBetter(int x, int y) {
        int res = 1;
        while (y > 0) {
            if ((y & 1) != 0) {
                res = res * x;
            }
            // y must now be an even power and be halved
            // x should be squared
            y = y >> 1; // y=y/2
            x = x * x;
        }
        return res;
    }
}

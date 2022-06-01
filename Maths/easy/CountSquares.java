package Maths.easy;

public class CountSquares {
    static int countSquares(int N) {
        if (N == 0 || N == 1)
            return 0;
        // code here
        N--;
        long end = N, low = 0, ans = 1, mid = 1;
        while (low <= end) {
            mid = (low + end) / 2;
            long inter = mid * mid;
            if (inter == N) {
                return (int) mid;
            }
            if (inter <= N) {
                ans = mid;
                low = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int) ans;
    }
}
package recursion.super_easy;

public class SumOfDigitsRecur {
    public static void main(String[] args) {
        System.out.println(sumOfDigRecur(179));
    }

    static int sumOfDigRecur(int x) {
        if (x <= 0) {
            return 0;
        }
        return x % 10 + sumOfDigRecur(x / 10);
    }

    // public static int sumofDigitsHelper(int x) {
    // // if (sum < 10) {
    // // return sum;
    // // }
    // int sum = 0;
    // while (x > 0) {
    // sum += x % 10;
    // x = x / 10;
    // }
    // return sum < 10 ? sum : sumofDigitsHelper(sum);
    // }
}

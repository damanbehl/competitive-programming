package recursion.super_easy;

public class NumberOfDigits {
    public static void main(String[] args) {
        System.out.println(findNoOfDigits(1, 0));
    }

    static int findNoOfDigits(int n, int result) {
        if (n < 1)
            return result;
        return findNoOfDigits(n / 10, ++result);
    }
}

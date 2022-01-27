package recursion.super_easy;

public class CountZeroesRecur {
    public static void main(String[] args) {
        System.out.println(countZeroes(1000000000));
    }

    static int countZeroes(int inp) {
        if (inp <= 0) {
            return 0;
        }
        return inp % 10 == 0 ? 1 + countZeroes(inp / 10) : countZeroes(inp / 10);
    }
}

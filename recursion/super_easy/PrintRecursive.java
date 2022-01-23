package recursion.super_easy;

public class PrintRecursive {
    public static void main(String[] args) {
        printNumbers(10);
    }

    static void printNumbers(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printNumbers(n - 1);
        System.out.print(n + " ");
    }
}

package Maths;

public class SwapNumbersXor {
    public static void main(String args[]) {
        int x = 100;
        int y = 200;
        System.out.println("x is>" + x + "y is>" + y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("x is>" + x + "y is>" + y);
    }
}

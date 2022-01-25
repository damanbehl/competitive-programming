package recursion.super_easy;

public class SumOfArray {
    public static void main(String[] args) {
        System.out.println(recursiveSumOArray(new int[] { 1, 3, 40000 }, 3));
    }

    static int recursiveSumOArray(int n[], int index) {
        if (index == 0) {
            return 0;
        }
        return n[--index] + recursiveSumOArray(n, index);
    }
}

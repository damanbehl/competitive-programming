package recursion.super_easy;

public class GeometricSum {
    public static void main(String[] args) {
        System.out.println(recurGeomSum(4));
    }

    static double recurGeomSum(int n) {
        if (n == 0) {
            return 1;
        }
        return 1 / Math.pow(2, n) + recurGeomSum(n - 1);
    }
}

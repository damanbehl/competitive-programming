package recursion.super_easy;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(convertToInteger("12345", 0));
    }

    static int convertToInteger(String x, int count) {
        if (x.length() - count == 0) {
            return 0;
        }
        return Character.getNumericValue(x.charAt(x.length() - 1 - count)) * (int) Math.pow(10, count)
                + convertToInteger(x, ++count);
    }
}

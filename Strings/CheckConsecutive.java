//https://www.codingninjas.com/codestudio/problems/remove-consecutive-duplicates_893195
package Strings;

public class CheckConsecutive {
    public static void main(String[] args) {
        System.out.println(removeConsecutiveDuplicates("aaaaaaa"));
    }

    public static String removeConsecutiveDuplicates(String s) {
        return skippingStones(s, "");
    }

    static String skippingStones(String s, String result) {
        if (s.length() == 1) {
            return result += s;
        }
        if (s.charAt(0) == s.charAt(1)) {
            return skippingStones(s.substring(1, s.length()), result);
        } else {
            return skippingStones(s.substring(1, s.length()), result += s.charAt(0));
        }
    }
}
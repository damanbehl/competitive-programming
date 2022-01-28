package recursion.super_easy;

public class PairStar {
    public static void main(String[] args) {
        System.out.println(pairStar("aaaa"));
    }

    static String pairStar(String input) {
        if (input.length() == 1) {
            return input;
        }
        if (input.charAt(0) == input.charAt(1)) {
            return input.charAt(0) + "*" + pairStar(input.substring(1, input.length()));
        } else {
            return input.charAt(0) + pairStar(input.substring(1, input.length()));
        }
    }
}

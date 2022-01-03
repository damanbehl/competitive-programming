package Strings;

/**
 * https://www.codingninjas.com/codestudio/problems/reverse-the-order-of-words-in-a-string_1264991
 */
public class ReverseStringWords {
    public static void main(String[] args) {
        String input = "   I am   a    star";
        String input2 = "Welcome     to   Coding   Ninjas";
        // System.out.println(reversedStingWordWise(input));
        System.out.println(reversedStingWordWiseTwo(input2));
    }

    // for question without extra white spaces
    static String reversedStingWordWise(String input) {
        int lastWhiteSpace = input.length();
        // int secondLastWhiteSpace = input.length() - 1;
        String result = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == ' ') {
                result = result + input.substring(i + 1, lastWhiteSpace) + " ";
                lastWhiteSpace = i;
            }
        }
        result = result + input.substring(0, lastWhiteSpace);
        return result;
    }

    static String reversedStingWordWiseTwo(String input) {
        input = " " + input.trim() + " ";
        int lastWhiteSpace = input.length() - 1;
        // int secondLastWhiteSpace = 0;
        String result = "";
        int i = input.length() - 2;
        while (i-- > 0) {
            if (input.charAt(i) == ' ' && i + 1 != lastWhiteSpace) {
                result = result + input.substring(i + 1, lastWhiteSpace) + " ";
                lastWhiteSpace = i;
            } else if (input.charAt(i) == ' ' && i + 1 == lastWhiteSpace) {
                lastWhiteSpace = i;
            }
        }
        result = result + input.substring(0, lastWhiteSpace);
        return result;
    }
}

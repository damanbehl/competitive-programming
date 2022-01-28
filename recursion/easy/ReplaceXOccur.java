//https://www.hackerearth.com/problem/algorithm/remove-character/submissions/
package recursion.easy;

import java.util.Scanner;

public class ReplaceXOccur {
    static String removeAllOccurrencesOfChar(String input, char c) {
        // Write your code here
        String result = "";
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != c) {
                result = result + input.charAt(i);
            }
        }
        return result;
    }

    static String removeAllOccOfCharRecursive(String input, char c, String res) {
        if (input.length() == 1) {
            if (input.charAt(0) == c)
                return res;
            else
                return res + input;
        }
        if (input.charAt(0) == c) {
            return removeAllOccOfCharRecursive(input.substring(1, input.length()), c, res);
        }
        return removeAllOccOfCharRecursive(input.substring(1, input.length()), c, res + input.charAt(0));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char c = sc.next().charAt(0);
        String ans = removeAllOccurrencesOfChar(input, c);
        System.out.println(ans);
    }
}

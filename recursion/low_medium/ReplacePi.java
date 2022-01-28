package recursion.low_medium;

import java.util.Scanner;

public class ReplacePi {
    public static void main(String[] args) {
        System.out.println(replacePiHelper("pippppiiiipi"));
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        // while (t-- >= 0) {
        // String input = sc.nextLine();
        // System.out.println(replacePiHelper(input));
        // }
    }

    static String replacePiHelper(String input) {
        if (input.length() <= 1) {
            return input;
        }
        input = input.toLowerCase();
        // return replaceAllPI(input, 0);
        return betterApproach(input, "");
    }

    static String replaceAllPI(String x, int si) {
        if (si >= x.length() - 1) {
            return x;
        }
        if (x.charAt(si) == 'p' && x.charAt(si + 1) == 'i') {
            if (si + 2 <= x.length() - 1) {
                x = x.substring(0, si) + "3.14" + x.substring(si + 2, x.length());
            } else {
                x = x.substring(0, si) + "3.14";

            }
            si = si + 4;
            return replaceAllPI(x, si);
        } else {
            return replaceAllPI(x, si + 1);
        }
    }

    static String betterApproach(String x, String res) {
        if (x.length() < 2) {
            return res + x;
        }
        if (x.charAt(0) == 'p' && x.charAt(1) == 'i') {
            res = res + "3.14";
            return betterApproach(x.substring(2, x.length()), res);
        } else {
            return betterApproach(x.substring(1, x.length()), res + x.charAt(0));
        }
    }
}

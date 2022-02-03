package recursion.low_medium;

/**
 * https://www.codingninjas.com/codestudio/problems/subsequences-of-string_985087
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subsequences {
    public static void main(String[] args) {
        // print(subsequences("bbb"));
        printSubsequences("xyz", "");
    }

    public static ArrayList<String> subsequences(String str) {
        // Write your code here
        ArrayList<String> sub = new ArrayList<String>();
        String[] res = returnSubsequences(str);
        Collections.addAll(sub, Arrays.copyOfRange(res, 1, res.length));
        return sub;
    }

    static String[] returnSubsequences(String x) {
        if (x.length() == 0) {
            return new String[] { "" };
        }
        String smallAns[] = returnSubsequences(x.substring(1));
        String ans[] = new String[2 * smallAns.length];
        for (int i = 0; i < smallAns.length; i++) {
            ans[i] = smallAns[i];
        }
        for (int i = 0; i < smallAns.length; i++) {
            ans[i + smallAns.length] = x.charAt(0) + smallAns[i];
        }
        return ans;
    }

    static void print(ArrayList<String> al) {
        for (String x : al) {
            System.out.print(x + " ");
        }
    }

    /**
     * less work
     * 
     * @param s:   input string
     * @param ans: answer we are carrying across function calls
     */
    static void printSubsequences(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans + " ");
            return;
        }
        // subsequence at any given point can be whether we include the first char in
        // ans or we do not
        // 2^n
        printSubsequences(s.substring(1), ans);
        printSubsequences(s.substring(1), ans += s.charAt(0));
    }
}

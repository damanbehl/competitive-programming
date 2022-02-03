package recursion.low_medium;

/**
 * https://www.codingninjas.com/codestudio/problems/subsequences-of-string_985087
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subsequences {
    public static void main(String[] args) {
        print(subsequences("bbb"));
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
}

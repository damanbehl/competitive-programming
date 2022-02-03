package recursion.medium;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://practice.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1/
 * https://www.codingninjas.com/codestudio/problems/possible-words-from-a-phone-number_1094907
 */
public class ReturnKeypadCombinations {
    public static void main(String[] args) throws Exception {
        List<String> result = findPossibleWords("793");
        print(result);
    }

    public static List<String> findPossibleWords(String s) throws Exception {
        // Write your code here.
        if (s.length() == 1) {
            return helper(s.charAt(0));
        }
        List<String> newResult = new ArrayList<String>();
        List<String> current = helper(s.charAt(s.length() - 1));
        List<String> smallAns = findPossibleWords(s.substring(0, s.length() - 1));
        for (String x : smallAns) {
            for (String y : current) {
                newResult.add(x.concat(y));
            }
        }
        return newResult;
    }

    // for gfg
    // static ArrayList<String> possibleWords(int a[], int N) {
    // // your code here
    // if (a.length == 1) {
    // return ghgHelper(a[0]);
    // }
    // ArrayList<String> newResult = new ArrayList<String>();
    // ArrayList<String> current = ghgHelper(a[N - 1]);
    // ArrayList<String> smallAns = possibleWords(Arrays.copyOfRange(a, 0, N - 1), N
    // - 1);
    // for (String x : smallAns) {
    // for (String y : current) {
    // newResult.add(x.concat(y));
    // }
    // }
    // return newResult;
    // }

    static List<String> helper(char s) throws Exception {
        List<String> subRes = new ArrayList<String>();
        switch (s) {
            case '1':
                Collections.addAll(subRes, new String[] { "" });
                break;
            case '2':
                Collections.addAll(subRes, new String[] { "a", "b", "c" });
                break;
            case '3':
                Collections.addAll(subRes, new String[] { "d", "e", "f" });
                break;
            case '4':
                Collections.addAll(subRes, new String[] { "g", "h", "i" });
                break;
            case '5':
                Collections.addAll(subRes, new String[] { "j", "k", "l" });
                break;
            case '6':
                Collections.addAll(subRes, new String[] { "m", "n", "o" });
                break;
            case '7':
                Collections.addAll(subRes, new String[] { "p", "q", "r", "s" });
                break;
            case '8':
                Collections.addAll(subRes, new String[] { "t", "u", "v" });
                break;

            case '9':
                Collections.addAll(subRes, new String[] { "w", "x", "y", "z" });
                break;
            case '0':
                Collections.addAll(subRes, new String[] { "" });
                break;

            default:
                throw new Exception("unwanted character");
        }
        return subRes;
    }

    static void print(List<String> al) {
        for (String x : al) {
            System.out.print(x + " ");
        }
    }
}

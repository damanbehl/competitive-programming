package Strings.hard;

//https://www.codingninjas.com/codestudio/problems/find-pattern-in-string_1112621
//KMP
public class FindPattern {
    public static boolean findPattern(String p, String s) {
        // Write your code here.
        int lps[] = generateLPS(p.toCharArray());
        int i = 0, j = 0;
        // i for string source
        while (i < s.length()) {
            if (p.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
            if (j == p.length()) {
                return true;
            }
        }
        return false;
    }

    public static int[] generateLPS(char[] patternArr) {
        int[] lps = new int[patternArr.length];
        int i = 1, j = 0;
        for (; i < patternArr.length;) {
            if (patternArr[i] == patternArr[j]) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
        return lps;
    }
}
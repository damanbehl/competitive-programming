package trie.easy;

import trie.concept.*;

public class PatternInString {
    // will give TLE
    public static boolean findPattern(String p, String s) {
        // Write your code here.
        String suffixes[] = getSuffixes(s);
        Trie t = new Trie();
        for (String x : suffixes) {
            t.add(x);
        }
        return t.search(p);
    }

    public static String[] getSuffixes(String word) {
        int n = word.length();
        String subStrings[] = new String[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            subStrings[index] = word.substring(i, n);
            index++;
        }
        return subStrings;
    }
}
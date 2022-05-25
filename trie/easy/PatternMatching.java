package trie.easy;

/**
 * Given a  list of n words and a pattern p that we want to search. Check if the pattern p is present the given words or not.
 */
import trie.concept.Trie;

class PatternMatching {
    public static void main(String[] args) {
        System.out.println(nonTriesSoln("abc def ghi hg", "abc"));
    }

    static boolean nonTriesSoln(String input, String pattern) {
        String words[] = input.split(" ");
        for (String x : words) {
            int LPS[] = generateLPS(pattern.toCharArray());
            int i = 0, j = 0;
            while (i < x.length()) {
                if (x.charAt(i) == pattern.charAt(j)) {
                    i++;
                    j++;
                } else {
                    if (j == 0) {
                        i++;
                    } else {
                        j = LPS[j - 1];
                    }
                }
                if (j == pattern.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean ifExists(String input, String pattern) {
        Trie dict = new Trie();
        boolean result = false;
        String words[] = input.split(" ");
        for (String x : words) {
            String suffixes[] = getSuffixes(x);
            for (String y : suffixes) {
                dict.add(y);
                if (dict.search(pattern)) {
                    return true;
                }
            }
        }
        return result;
    }

    static String[] getSuffixes(String input) {
        String result[] = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
            result[i] = input.substring(i, input.length());
        }
        return result;
    }

    static int[] generateLPS(char[] pattern) {
        int[] LPS = new int[pattern.length];
        int i = 1, prevLPS = 0;
        while (i < pattern.length) {
            if (pattern[i] == pattern[prevLPS]) {
                LPS[i] = prevLPS + 1;
                i++;
                prevLPS++;
            } else {
                if (prevLPS == 0) {
                    LPS[i] = 0;
                    i++;
                } else {
                    prevLPS = LPS[prevLPS - 1];
                }
            }
        }
        return LPS;
    }
}

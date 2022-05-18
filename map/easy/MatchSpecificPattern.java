package map.easy;

//https://www.codingninjas.com/codestudio/problems/match-specific-pattern_981301
import java.util.*;

public class MatchSpecificPattern {

    public static List<String> matchSpecificPattern(List<String> words, int n, String pattern) {
        // Write you code here.
        List<String> result = new ArrayList<>();
        HashMap<Character, Character> dict;
        HashMap<Character, Character> reverse;
        for (String x : words) {
            dict = new HashMap<>();
            reverse = new HashMap<>();
            boolean toAdd = true;
            if (x.length() != pattern.length()) {
                toAdd = false;
                continue;
            }
            for (int i = 0; i < x.length(); i++) {
                char c = x.charAt(i);
                char p = pattern.charAt(i);
                if (dict.containsKey(c) && reverse.containsKey(p)) {
                    if (dict.get(c) != p || reverse.get(p) != c) {
                        toAdd = false;
                        break;
                    }
                } else if (dict.containsKey(c) || reverse.containsKey(p)) {
                    toAdd = false;
                    break;
                } else {
                    dict.put(c, p);
                    reverse.put(p, c);
                }
            }
            if (toAdd) {
                result.add(x);
            }
        }
        return result;
    }

}

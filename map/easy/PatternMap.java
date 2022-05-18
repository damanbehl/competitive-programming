package map.easy;

//https://www.codingninjas.com/codestudio/problems/pattern-matching_1229403
import java.util.ArrayList;
import java.util.HashMap;

public class PatternMap {
    public static boolean isPatternMatching(String pattern, ArrayList<String> words) {
        boolean result = true;
        // Write your code here.
        HashMap<String, Character> reverseDict = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            if (reverseDict.containsKey(words.get(i))) {
                if (reverseDict.get(words.get(i)) != pattern.charAt(i)) {
                    result = false;
                    break;
                }
            } else {
                reverseDict.put(words.get(i), pattern.charAt(i));
            }
        }
        return result;
    }
}
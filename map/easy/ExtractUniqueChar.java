package map.easy;

import java.util.HashMap;

public class ExtractUniqueChar {
    public static void main(String[] args) {

    }

    public static String extractUnique(String input) {
        String result = "";
        HashMap<Character, Boolean> hm = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            if (!hm.containsKey(ch)) {
                result += ch;
                hm.put(ch, true);
            }
        }
        return result;
    }
}

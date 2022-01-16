//https://www.codingninjas.com/codestudio/problems/check-permutation_1172164

package Strings;

import java.util.HashMap;

public class CheckAnagram {
    public static void main(String[] args) {
        System.out.println(areAnagram("abc", "cbd"));
    }

    public static boolean areAnagram(String str1, String str2) {
        boolean result = true;
        // Write your code here.
        if (str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            hm1.put(str1.charAt(i), hm1.getOrDefault(str1.charAt(i), 1));
            hm2.put(str2.charAt(i), hm2.getOrDefault(str2.charAt(i), 1));
        }
        for (char c : hm1.keySet()) {
            if (hm1.getOrDefault(c, 0) != hm2.getOrDefault(c, 0)) {
                return false;
            }
        }
        return result;
    }
}
package Strings;

import java.util.ArrayList;
import java.util.List;

public class SubStrings {
    public static void main(String[] args) {
        String name = "daman";
        String input = "ab";
        for (String x : getSubStrings(input)) {
            System.out.println(x);
        }
    }

    static List<String> getSubStrings(String input) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                result.add(input.substring(i, j + 1));
            }
        }
        return result;
    }
}

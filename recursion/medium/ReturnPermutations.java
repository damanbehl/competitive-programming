package recursion.medium;

//https://www.codingninjas.com/codestudio/problems/permutations-of-a-string_985254
import java.util.*;

public class ReturnPermutations {
    public static void main(String[] args) {
        System.out.println(generatePermutations("abc"));
    }

    public static ArrayList<String> generatePermutations(String str) {
        // Write your code here
        ArrayList<String> result = new ArrayList<String>();
        calculateAllPerms(str, result, "");
        Collections.sort(result);
        return result;
    }

    static void calculateAllPerms(String input, ArrayList<String> result, String carryOver) {
        if (input.length() == 0) {
            result.add(carryOver);
            return;
        } else {
            for (int i = 0; i < input.length(); i++) {
                calculateAllPerms(input.substring(1, input.length()), result, carryOver + input.charAt(0));
                input = input.substring(1, input.length()) + input.charAt(0);
            }
        }
    }
}

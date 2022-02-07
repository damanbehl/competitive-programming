package recursion.medium;

import java.util.ArrayList;
import java.util.Collections;

public class ReturnAllCodes {
    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<String>();
        returnAllCodes("1113013", 0, result, "");
        Collections.sort(result);
        System.out.println(result);
    }

    static void returnAllCodes(String input, int index, ArrayList<String> result, String carryOver) {
        if (index == input.length()) {
            result.add(carryOver);
            return;
        } else {
            char query = input.charAt(index);
            if (query == '0') {
                return;
            } else {
                int inter;
                if (index + 1 < input.length()
                        && ((query == '1' || query == '2') && Character.getNumericValue(input.charAt(index + 1)) >= 0
                                && Character.getNumericValue(input.charAt(index + 1)) <= 6)) {
                    inter = Integer.parseInt(input.substring(index, index + 2)) + 96;
                    String carryOverBranch = carryOver + (char) inter;
                    returnAllCodes(input, index + 2, result, carryOverBranch);
                }
                inter = Character.getNumericValue(query) + 96;
                carryOver += ((char) inter);
                returnAllCodes(input, index + 1, result, carryOver);
            }
        }
    }
}

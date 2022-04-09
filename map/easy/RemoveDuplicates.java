package map.easy;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> arr) {
        HashMap<Integer, Boolean> seen = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int x : arr) {
            if (seen.containsKey(x))
                continue;

            seen.put(x, true);
            result.add(x);
        }
        return result;
    }
}

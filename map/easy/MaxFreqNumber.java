package map.easy;

//https://www.codingninjas.com/codestudio/problems/maximum-frequency-number_920319
import java.util.HashMap;

public class MaxFreqNumber {
    public static int maxFrequencyNumber(int n, int[] arr) {
        // Write your code here
        HashMap<Integer, Integer> freq = new HashMap<>();
        int max = 0;
        int maxNumber = -1;
        for (int x : arr) {
            int curr = freq.getOrDefault(x, 0) + 1;
            if (curr >= max) {
                max = curr;
                maxNumber = x;
            }
            freq.put(x, curr);
        }
        for (int x : arr) {
            if (freq.get(x) == max) {
                return x;
            }
        }
        return maxNumber;
    }
}
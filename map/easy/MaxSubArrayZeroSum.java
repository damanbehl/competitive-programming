package map.easy;

//https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum
import java.util.HashMap;

public class MaxSubArrayZeroSum {
    public static void main(String[] args) {
        int input[] = { 95, -97, -387, -435, -5, -70, 897, 127, 23, 284 };
        System.out.println(maxLen(input, input.length));
    }

    // first sum 0 is on -1 index
    // occurence is map for <sum:index>
    // track previously occurred sums on repitition find out the stretch of elements
    // ,
    // that sum to 0
    static int maxLen(int arr[], int n) {
        // Your code here
        HashMap<Integer, Integer> occurrence = new HashMap<>();
        occurrence.put(0, -1);
        int sumT = 0;
        int maxSubArray = 0;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            sumT += x;
            if (occurrence.containsKey(sumT)) {
                int foundAt = occurrence.get(sumT);
                if (i - foundAt > maxSubArray) {
                    maxSubArray = i - foundAt;
                }
            } else {
                occurrence.put(sumT, i);
            }
        }
        return maxSubArray;
    }
}
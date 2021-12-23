package arrays;

import java.util.HashMap;

/**
 * Problem Link
 * https://www.codingninjas.com/codestudio/problems/number-of-pairs-with-given-sum_630509
 * (arr[i],arr[j]) == (arr[j],arr[i]) considered as same
 */

public class PairSumWithRep {
    public static void main(String[] args) {
        int input[] = { 1, 3, 6, 2, 5, 4, 3, 2, 4 };
        int input2[] = { 2, 8, 10, 5, -2, 5 }; // SUM 10 PAIRS 2
        int input3[] = { 10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1 }; // SUM 11 PAIRS 9
        int input4[] = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }; // SUM 20 PAIRS 45
        System.out.println(pairsWithGivenSum(input4, 20));
    }

    public static long pairsWithGivenSum(int arr[], int sum) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        long result = 0L;
        for (int x : arr) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        for (int x : arr) {
            Integer query = hm.getOrDefault(sum - x, 0);
            // Account for the number itself if sum-x == x
            if (x == sum - x && query.intValue() > 1) {
                result = result + query.intValue() - 1;
                hm.put(x, query.intValue() - 1);
            } else if (x != sum - x && query.intValue() > 0) {
                result = result + query.intValue();
                Integer ownFreq = hm.get(x);
                hm.put(x, ownFreq.intValue() - 1);
            }
        }
        return result;
    }
}
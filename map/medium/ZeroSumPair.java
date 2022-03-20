package map.medium;

//https://www.codingninjas.com/codestudio/problems/zero-pair-sum_2033591
import java.util.HashMap;
import java.util.ArrayList;

public class ZeroSumPair {
    static int ZeroPairSum(int n, ArrayList<Integer> arr) {
        // Write your code here.
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int x : arr) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        for (int x : arr) {
            int complementCount = hm.getOrDefault(-x, 0);
            if (complementCount > 0) {
                // hm.put(-x,complementCount-1);
                // if(x==0 && complementCount-1<=0){
                // continue;
                // } else if(x==0){
                // count = count + complementCount-1;
                // hm.put(x, hm.get(x)-1);
                // continue;
                // }
                if (x == 0) {
                    complementCount--;
                }
                count += complementCount;
            }
            hm.put(x, hm.get(x) - 1);
        }
        return count;
    }

}

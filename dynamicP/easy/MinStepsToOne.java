package dynamicP.easy;

//https://www.codingninjas.com/codestudio/problems/min-steps-to-one-using-dp_920548
import java.util.HashMap;

public class MinStepsToOne {
    static HashMap<Integer, Integer> cache;

    public static int countStepsToOne(int n) {
        cache = new HashMap<>();
        cache.put(1, 0);
        return countStepsToOneDP(n);
    }

    public static int countStepsToOneHelper(int n) {
        if (n == 1) {
            return 0;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int noOfSteps = Integer.MAX_VALUE;
        ;
        if (n % 2 == 0) {
            noOfSteps = 1 + countStepsToOneHelper(n / 2);
        }
        if (n % 3 == 0) {
            noOfSteps = Math.min(1 + countStepsToOneHelper(n / 3), noOfSteps);
        }
        noOfSteps = Math.min(1 + countStepsToOneHelper(n - 1), noOfSteps);
        cache.put(n, noOfSteps);
        return noOfSteps;
        // Write your code here.
    }

    public static int countStepsToOneDP(int n) {
        if (n == 1) {
            return 0;
        }
        for (int i = 2; i <= n; i++) {
            int dummy = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                dummy = cache.get(i / 3);
            }
            if (i % 2 == 0) {
                dummy = Math.min(dummy, cache.get(i / 2));
            }
            dummy = Math.min(dummy, cache.get(i - 1));
            dummy++;
            cache.put(i, dummy);
        }
        return cache.get(n);
    }
}
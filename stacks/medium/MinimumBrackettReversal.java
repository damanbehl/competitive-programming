package stacks.medium;

import java.util.Stack;

public class MinimumBrackettReversal {
    public static int findMinimumCost(String str) {
        // Write your code here
        int length = str.length();
        if (length % 2 != 0) {
            return -1;
        }
        Stack<Character> tally = new Stack<Character>();
        int workToDo = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '}') {
                if (tally.isEmpty()) {
                    workToDo++;
                    tally.push('{');
                } else {
                    tally.pop();
                }
            } else {
                tally.push('{');
            }
        }
        if (!tally.isEmpty()) {
            workToDo += (tally.size() / 2);
        }
        return workToDo;
    }
}

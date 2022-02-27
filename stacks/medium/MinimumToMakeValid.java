package stacks.medium;

//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
import java.util.Stack;

public class MinimumToMakeValid {
    public int minAddToMakeValid(String s) {
        Stack<Character> tally = new Stack<Character>();
        int workToDo = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (tally.isEmpty()) {
                    workToDo++;
                } else {
                    tally.pop();
                }
            } else {
                tally.push('(');
            }
        }
        if (!tally.isEmpty()) {
            workToDo += tally.size();
        }
        return workToDo;
    }
}
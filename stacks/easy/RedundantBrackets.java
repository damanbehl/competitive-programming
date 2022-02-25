package stacks.easy;

//https://www.codingninjas.com/codestudio/problems/redundant-brackets_975473
import java.util.Stack;

public class RedundantBrackets {
    public static void main(String[] args) {

    }

    public static boolean findRedundantBrackets(String s) {
        // Write your code here.
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);
            int counter = 0;
            if (check == ')') {
                while (st.size() > 0 && st.peek() != '(') {
                    if (st.peek() == '+' || st.peek() == '-' || st.peek() == '*' || st.peek() == '/') {
                        counter++;
                    }
                    st.pop();
                }
                if (counter == 0) {
                    return true;
                }
                st.pop();
            } else {
                st.push(check);
            }
        }
        return false;
    }
}

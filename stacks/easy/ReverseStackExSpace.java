package stacks.easy;

import java.util.Stack;

public class ReverseStackExSpace {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 15; i++) {
            stack.add(i);
        }
        reverseUsingExtraSpace(stack, stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    static void reverseUsingExtraSpace(Stack<Integer> st, int n) {
        Stack<Integer> st2 = new Stack<>();
        for (int i = 0; i < n; i++) {
            int x = st.peek();
            st.pop();
            transfer(st, st2, n - i - 1);
            st.push(x);
            transfer(st2, st, n - i - 1);
        }
    }

    static void transfer(Stack<Integer> s1, Stack<Integer> s2, int x) {
        for (int i = 0; i < x; i++) {
            int temp = s1.peek();
            s1.pop();
            s2.push(temp);
        }
    }
}

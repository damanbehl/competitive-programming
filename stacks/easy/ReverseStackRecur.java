package stacks.easy;

import java.util.Stack;

public class ReverseStackRecur {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            stack.add(i);
        }
        // Iterator<Integer> iter = stack.iterator();
        // while (iter.hasNext()) {
        // System.out.print(iter.next() + " ");
        // }
        // System.out.println();
        reverseStack(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void reverseStack(Stack<Integer> stack) {
        // write your code here
        if (stack.size() == 0) {
            return;
        } else {
            int x = stack.peek();
            stack.pop();
            reverseStack(stack);
            insertAtBottom(x, stack);
        }
    }

    public static void insertAtBottom(int x, Stack<Integer> stack) {
        if (stack.size() == 0) {
            stack.push(x);
        } else {
            int temp = stack.peek();
            stack.pop();
            insertAtBottom(x, stack);
            stack.push(temp);
        }
    }
}

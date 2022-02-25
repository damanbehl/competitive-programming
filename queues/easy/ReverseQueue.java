package queues.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> input = new LinkedList<Integer>();
        for (int i = 1; i <= 5; i++) {
            input.add(i);
        }
        input = rev(input);
        while (!input.isEmpty()) {
            System.out.print(input.poll() + " ");
        }
    }

    public static Queue<Integer> reverseQueueUsingStack(Queue<Integer> q) {

        Stack<Integer> st = new Stack<Integer>();
        // Write your code here.
        while (!q.isEmpty()) {
            st.push(q.peek());
            q.poll();
        }
        while (!st.isEmpty()) {
            q.add(st.pop());
        }
        return q;
    }
    // reverse recursive
    public static Queue<Integer> rev(Queue<Integer> q) {
        if (q.size() == 0) {
            return q;
        } else {
            int x = q.poll();
            q = rev(q);
            q.add(x);
            return q;
        }
    }

}

package stacks.concept;

import exception.StackEmptyException;
import exception.StackFullException;

public class StackUse {
    public static void main(String[] args) throws StackFullException {
        StackUsingArray st1 = new StackUsingArray();
        for (int i = 1; i <= 5; i++) {
            st1.push(i);
        }
        while (!st1.isEmpty()) {
            try {
                System.out.println(st1.pop());
            } catch (StackEmptyException e) {
                // Will never reach here
                // e.printStackTrace();
            }
        }
    }
}

package stacks.easy;

//https://leetcode.com/problems/valid-parentheses/submissions/
//https://www.codingninjas.com/codestudio/problems/valid-parenthesis_795104?leftPanelTab=1
import java.util.HashMap;

class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
        next = null;
    }
}

class Stack {
    private Node head;
    private int size;

    public Stack() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public char peek() {
        if (size == 0) {
            return '0';
        }
        return head.data;
    }

    public void push(char elem) {
        Node newNode = new Node(elem);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public char pop() {
        if (size == 0) {
            return '0';
        }
        char ret = head.data;
        head = head.next;
        size--;
        return ret;
    }
}

public class ValidParanthesis {
    public static boolean isValidParenthesis(String input) {
        // Write your code here.
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put('{', '}');
        hm.put('(', ')');
        hm.put('[', ']');
        Stack stack = new Stack();
        for (int i = 0; i < input.length(); i++) {
            char toCompare = input.charAt(i);
            if (toCompare == ')' || toCompare == '}' || toCompare == ']') {
                if (stack.size() == 0) {
                    return false;
                }
                if (toCompare != hm.get(stack.pop())) {
                    return false;
                }
            } else {
                stack.push(toCompare);
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}

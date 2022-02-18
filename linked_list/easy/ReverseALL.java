package linked_list.easy;

//https://leetcode.com/problems/reverse-linked-list/
import linked_list.concept.Node;

import java.util.ArrayList;

import linked_list.concept.LinkedListUse;

public class ReverseALL {
    Node<Integer> retHead = null;

    public static void main(String[] args) {
        Node<Integer> head = LinkedListUse.takeInput();
        ReverseALL ob = new ReverseALL();
        head = ob.reverseList(head);
        LinkedListUse.print(head);
    }

    public Node<Integer> reverseList(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            return reverseListHelper(head).get(0);
        }
    }

    public ArrayList<Node<Integer>> reverseListHelper(Node<Integer> head) {
        if (head.next == null) {
            ArrayList<Node<Integer>> al = new ArrayList<Node<Integer>>();
            al.add(head);
            al.add(head);
            return al;
        } else {
            Node<Integer> temp = head;
            ArrayList<Node<Integer>> res = reverseListHelper(head.next);
            Node<Integer> tail = res.get(1);
            temp.next = null;
            tail.next = temp;
            tail = tail.next;
            res.set(1, tail);
            return res;
        }
    }

    public void reverseListZeroMS(Node<Integer> head, Node<Integer> prevHead) {
        if (head != null) {
            reverseListZeroMS(head.next, head);
            head.next = prevHead;
        } else {
            retHead = prevHead;
        }
    }

    public Node<Integer> reverseLLRBetter(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> temp = head.next;
        Node<Integer> smallHead = reverseLLRBetter(head.next);
        temp.next = head;
        head.next = null;
        return smallHead;
    }
}

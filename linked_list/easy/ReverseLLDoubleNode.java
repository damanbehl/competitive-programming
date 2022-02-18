package linked_list.easy;

import linked_list.concept.Node;
import linked_list.concept.DoubleNode;
import linked_list.concept.LinkedListUse;

public class ReverseLLDoubleNode {
    public static void main(String[] args) {
        Node<Integer> head = LinkedListUse.takeInput();
        DoubleNode result = reverseLLBetter(head);
        LinkedListUse.print(result.head);
    }

    public static DoubleNode reverseLLBetter(Node<Integer> head) {
        if (head == null || head.next == null) {
            DoubleNode ans = new DoubleNode();
            ans.head = head;
            ans.tail = head;
            return ans;
        }
        DoubleNode smallAns = reverseLLBetter(head.next);
        smallAns.tail.next = head;
        head.next = null;
        smallAns.tail = head;
        return smallAns;
    }
}

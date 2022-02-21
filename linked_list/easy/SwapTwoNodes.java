package linked_list.easy;

import linked_list.concept.Node;
import linked_list.concept.LinkedListUse;

//swap two nodes without swapping data
public class SwapTwoNodes {
    public static void main(String[] args) {
        Node<Integer> head = LinkedListUse.takeInput();
        LinkedListUse.print(head);
        head = swapNodes(head, 0, 4);
        LinkedListUse.print(head);
    }

    static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
        if (i == j) {
            return head;
        }
        Node<Integer> ithNode;
        Node<Integer> jthNode;
        Node<Integer> nextToIth;
        int iter = 0;
        if (i > j) {
            i = i ^ j;
            j = i ^ j;
            i = i ^ j;
        }
        if (i == 0) {
            ithNode = head;
            jthNode = null;
            nextToIth = head.next;
            while (head.next != null) {
                head = head.next;
                iter++;
                if (iter == j - 1) {
                    jthNode = head.next;
                    ithNode.next = jthNode.next;
                    head.next = ithNode;
                    jthNode.next = nextToIth;
                }
            }
            return jthNode;
        } else {
            Node<Integer> origHead = head;
            Node<Integer> prevToith = null;
            ithNode = null;
            nextToIth = null;
            while (head != null && head.next != null) {
                if (iter == i - 1) {
                    prevToith = head;
                    ithNode = head.next;
                    nextToIth = ithNode.next;
                }
                if (iter == j - 1) {
                    jthNode = head.next;
                    ithNode.next = jthNode.next;
                    head.next = ithNode;
                    prevToith.next = jthNode;
                    jthNode.next = nextToIth;
                }
                head = head.next;
                iter++;
            }
            System.out.println("exiting function");
            return origHead;
        }
    }
}

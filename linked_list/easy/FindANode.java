package linked_list.easy;

import linked_list.concept.Node;
import linked_list.concept.LinkedListUse;
import java.util.Scanner;

public class FindANode {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        LinkedListUse.print(head);
        System.out.println(findNode(head, 7));
    }

    public static int findNode(Node<Integer> head, int n) {
        // Write your code here.
        int i = -1;
        while (head != null) {
            i++;
            if (head.data == n) {
                return i;
            }
            head = head.next;
        }
        return -1;
    }

    public static int findNodeRecursive(Node<Integer> head, int n) {
        // Write your code here.
        return findNodeHelper(head, n, 0);
    }

    public static int findNodeHelper(Node<Integer> head, int n, int i) {
        if (head == null) {
            return -1;
        }
        if (head.data.intValue() == n) {
            return i;
        }
        return findNodeHelper(head.next, n, ++i);

    }

    public static Node<Integer> takeInput() {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null;
        Node<Integer> tail = null;
        while (data != -1) {
            if (head == null) {
                head = new Node<Integer>(data);
                tail = head;
            } else {
                tail.next = new Node<Integer>(data);
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        sc.close();
        return head;
    }
}

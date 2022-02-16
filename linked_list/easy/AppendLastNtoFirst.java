package linked_list.easy;

import java.util.Scanner;
import linked_list.concept.LinkedListUse;

import linked_list.concept.Node;

public class AppendLastNtoFirst {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        LinkedListUse.print(head);
        int k = 4;
        head = moveToFront(head, k);
        LinkedListUse.print(head);

    }

    public static Node<Integer> moveToFront(Node<Integer> head, int k) {
        if (k == 0) {
            return head;
        }
        Node<Integer> temp = head;
        int length = length(head);
        int i = 0;
        while (i < (length - k - 1) && temp != null) {
            temp = temp.next;
            i++;
        }
        Node<Integer> holdNRelease = temp.next;
        temp.next = null;
        temp = holdNRelease;
        i = 0;
        while (i < k - 1 && temp != null) {
            temp = temp.next;
            i++;
        }
        temp.next = head;
        return holdNRelease;

    }

    public static Node<Integer> takeInput() {
        // time complexity O(n)
        // for every iteration of while loop constant work is being done
        // n times
        Node<Integer> head = null;
        Node<Integer> tail = null;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
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
        return head;
    }

    static int length(Node<Integer> head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}

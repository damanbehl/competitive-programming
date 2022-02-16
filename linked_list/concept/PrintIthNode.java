package linked_list.concept;

import java.util.Scanner;

public class PrintIthNode {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        // print(head);
        // System.out.println(length(head));
        int position = -1;
        printIthNode(head, position);
    }

    static Node<Integer> takeInput() {
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
        return head;
    }

    static void print(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    static int length(Node<Integer> head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    static <T> void printIthNode(Node<T> head, int position) {
        if (position < 0) {
            return;
        }
        int i = 0;
        while (i < position && head != null) {
            head = head.next;
            i++;
        }
        if (head != null) {
            System.out.println(head.data);
        }
    }
}

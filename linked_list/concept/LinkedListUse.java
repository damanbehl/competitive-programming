package linked_list.concept;

import java.util.Scanner;

public class LinkedListUse {
    public static void main(String[] args) {
        Node<Integer> n1 = takeInput();
        // n1 = insert(n1, 0, 44);
        print(n1);
        n1 = DeleteIthNode.deleteNode(n1, 2);
        print(n1);
    }

    public static <T> void print(Node<T> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
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

    public static Node<Integer> insert(Node<Integer> head, int pos, int data) {
        if (pos < 0) {
            return head;
        }
        Node<Integer> toInsert = new Node<Integer>(data);
        if (pos == 0) {
            toInsert.next = head;
            return toInsert;
        } else {
            int i = 0;
            Node<Integer> temp = head;
            while (i < pos - 1) {
                temp = temp.next;
                i++;
            }
            toInsert.next = temp.next;
            temp.next = toInsert;
            return head;
        }
    }

    public static int length(Node<Integer> head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    public static <T> String returnLinkedListasString(Node<T> head) {
        String result = "";
        while (head != null) {
            result = result + " " + head.data;
            head = head.next;
        }
        return result;
    }
}

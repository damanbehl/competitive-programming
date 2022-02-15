package linked_list.concept;

public class LinkedListUse {
    public static void main(String[] args) {
        Node<Integer> n1 = new Node<Integer>(10);
        Node<Integer> n2 = new Node<Integer>(20);
        Node<Integer> n3 = new Node<Integer>(30);
        n1.next = n2;
        n2.next = n3;
        print(n1);
        print(n1);
    }

    public static <T> void print(Node<T> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}

package linked_list.concept;

public class DeleteIthNode {
    public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
        if (pos < 0) {
            return head;
        }
        // Write your code here.
        if (pos == 0) {
            return head != null ? head.next : head;
            // if (head != null) {
            // return head.next;
            // } else {
            // return head;
            // }
        } else {
            Node<Integer> temp = head;
            while (pos > 1 && temp != null) {
                temp = temp.next;
                pos--;
            }
            if (temp != null && temp.next != null) {
                temp.next = temp.next.next;
            }
            return head;
        }
    }
}

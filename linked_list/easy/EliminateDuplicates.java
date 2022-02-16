package linked_list.easy;

//https://www.codingninjas.com/codestudio/problems/remove-duplicates-from-unsorted-linked-list_1069331
import java.util.HashMap;
import linked_list.concept.Node;
import linked_list.concept.LinkedListUse;

public class EliminateDuplicates {
    public static void main(String[] args) {
        Node<Integer> head = LinkedListUse.takeInput();
        LinkedListUse.print(head);
        head = removeDuplicates(head);
        LinkedListUse.print(head);
    }

    public static Node<Integer> removeDuplicates(Node<Integer> head) {

        // Write your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        Node<Integer> temp = head;
        while (temp != null) {
            hm.put(temp.data, 1);
            if (temp.next != null && hm.get(temp.next.data) != null) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }

        }
        return head;
    }
}

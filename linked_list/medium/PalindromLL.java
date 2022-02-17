package linked_list.medium;

//https://www.codingninjas.com/codestudio/problems/palindrom-linked-list_799352
import linked_list.concept.Node;
import linked_list.concept.LinkedListUse;
import utility.OutputToFile;

public class PalindromLL {
    public static void main(String[] args) {
        System.out.println("Enter the linked list");
        Node<Integer> head = LinkedListUse.takeInput();
        int length = LinkedListUse.length(head);
        System.out.println("length of ll is >" + length);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(Node<Integer> head) {
        if (head == null || head.next == null) {
            return true;
        }
        // Write your code here!
        Node<Integer> fastPtr = head;
        Node<Integer> slowPtr = head;
        Node<Integer> prevSlowPtr = head;
        Node<Integer> mid = null;
        Node<Integer> secondHalf = null;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            prevSlowPtr = slowPtr;
            slowPtr = slowPtr.next;
        }
        if (fastPtr != null) {
            // mid for if we need to reverse the second half back again
            mid = slowPtr;
            slowPtr = slowPtr.next;
        }
        prevSlowPtr.next = null;
        secondHalf = reverse(slowPtr);
        // System.out.println("length of first half=" + LinkedListUse.length(head));
        // OutputToFile writeOb = new OutputToFile();
        // writeOb.writeOutputToFile("first_half",
        // LinkedListUse.returnLinkedListasString(head));
        // System.out.println("length of second half=" +
        // LinkedListUse.length(secondHalf));
        // writeOb.writeOutputToFile("second_half",
        // LinkedListUse.returnLinkedListasString(secondHalf));
        return compareLists(head, secondHalf);
    }

    public static Node<Integer> reverse(Node<Integer> head) {
        Node<Integer> prev = null;
        Node<Integer> current = head;
        Node<Integer> temp;
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    public static boolean compareLists(Node<Integer> head1, Node<Integer> head2) {
        boolean retVal = true;
        while (head1 != null && head2 != null) {
            if (head1.data.intValue() != head2.data.intValue()) {
                System.out.println(head1.data == head2.data);
                System.out.println("false for head1 data=" + head1.data + "   head 2 data" + head2.data);
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 != null || head2 != null) {
            System.out.println("false for one of them being not null");
            return false;
        }
        return retVal;
    }
}

package priority_queue.hard;

//https://leetcode.com/problems/merge-k-sorted-lists
import java.util.Comparator;
import java.util.PriorityQueue;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeKSortedLists {
    static class LNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            if (o1.val < o2.val) {
                return -1;
            } else if (o1.val > o2.val) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        MergeKSortedLists.LNodeComparator comp = new MergeKSortedLists.LNodeComparator();
        PriorityQueue<ListNode> pq = new PriorityQueue<>(comp);
        int n = lists.length;
        for (int i = 0; i < n; i++) {
            ListNode head = lists[i];
            while (head != null) {
                pq.add(head);
                head = head.next;
            }
        }
        ListNode retVal = pq.peek();
        if (retVal == null) {
            return null;
        }
        pq.remove();
        ListNode dummy = retVal;
        while (!pq.isEmpty()) {
            dummy.next = pq.remove();
            dummy = dummy.next;
        }
        dummy.next = null;
        return retVal;
    }
}

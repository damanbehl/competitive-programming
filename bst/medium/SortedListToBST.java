package bst.medium;

//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree
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

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        // single node
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode prevToSlow = head;
        ListNode slow = head;
        ListNode fast = head;
        TreeNode middle;
        while (fast != null && fast.next != null) {
            prevToSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        middle = new TreeNode(slow.val);
        prevToSlow.next = null;
        middle.left = sortedListToBST(head);
        middle.right = sortedListToBST(slow.next);
        return middle;
    }
}
package stacks.easy;

//https://leetcode.com/problems/next-greater-element-i/
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            int check = nums2[i];
            while (!st.isEmpty() && st.peek() < check) {
                hm.put(st.pop(), check);
            }
            st.push(check);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = hm.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}

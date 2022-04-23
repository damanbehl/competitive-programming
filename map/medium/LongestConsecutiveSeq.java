package map.medium;

//https://nados.io/question/longest-consecutive-sequence-of-elements
//https://leetcode.com/problems/longest-consecutive-sequence/
import java.util.HashMap;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {

        int input[] = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
        HashMap<Integer, Boolean> isStart = new HashMap<>();
        for (int i : input) {
            isStart.put(i, true);
        }
        for (int i : input) {
            if (isStart.containsKey(i - 1)) {
                isStart.put(i, false);
            }
        }
        int sv = 0;
        int maxSeq = 0;
        for (int i : input) {
            if (isStart.get(i)) {
                int incr = 0;
                while (isStart.get(i + incr) != null) {
                    incr++;
                }
                if (incr > maxSeq) {
                    maxSeq = incr;
                    sv = i;
                }
            }
        }
        int arr[] = new int[maxSeq];
        for (int i = 0; i < maxSeq; i++) {
            arr[i] = sv + i;
        }
    }
}
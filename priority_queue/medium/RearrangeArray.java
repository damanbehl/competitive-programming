package priority_queue.medium;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Comparator;
//https://www.codingninjas.com/codestudio/problems/rearrange-the-array_799559

class KeyComparator implements Comparator<Key> {
    public int compare(Key k1, Key k2) {
        if (k1.freq < k2.freq) {
            return 1;
        } else if (k1.freq > k2.freq) {
            return -1;
        } else {
            return 0;
        }
    }
}

class Key {
    public int val;
    public int freq;

    public Key(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }
}

public class RearrangeArray {

    public static ArrayList<Integer> rearrange(ArrayList<Integer> num) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int i = 0; i < num.size(); i++) {
            freq.put(num.get(i), freq.getOrDefault(num.get(i), 0) + 1);
        }
        KeyComparator kComp = new KeyComparator();
        PriorityQueue<Key> pq = new PriorityQueue<>(kComp);
        for (int i = 0; i < num.size(); i++) {
            int val = num.get(i);
            if (!visited.getOrDefault(val, false) && freq.containsKey(val)) {
                Key k = new Key(val, freq.get(val));
                pq.add(k);
            }
            visited.put(val, true);
        }
        ArrayList<Integer> res = new ArrayList<>();
        Key prev = new Key(-1, -1);
        while (pq.size() != 0) {
            Key k = pq.peek();
            pq.poll();
            res.add(k.val);
            (k.freq)--;
            if (prev.freq > 0) {
                pq.add(prev);
            }
            prev = k;
        }
        if (res.size() != num.size()) {
            res.clear();
            res.add(Integer.MIN_VALUE);
        }
        return res;
    }
}
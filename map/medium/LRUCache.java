package map.medium;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 * TODO: 14/22 TEST CASES passed
 * find why rest fail
 */
public class LRUCache {
    TreeSet<Map.Entry<Integer, Integer>> set;
    HashMap<Integer, Pair> map;
    int capacity;
    int currNo;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        set = new TreeSet<>(new SetComp());
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int freq = map.get(key).useCounter;
            int value = map.get(key).value;
            AbstractMap.SimpleEntry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(key, freq);
            set.remove(entry);
            entry.setValue(++currNo);
            set.add(entry);
            map.put(key, new Pair(key, value, currNo));
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            int freq = map.get(key).useCounter;
            AbstractMap.SimpleEntry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(key, freq);
            set.remove(entry);
            entry.setValue(++currNo);
            set.add(entry);
            map.put(key, new Pair(key, value, currNo));
            return;
        }
        currNo++;
        if (currNo > capacity) {
            Iterator<Map.Entry<Integer, Integer>> setIterator = set.iterator();
            System.out.println(
                    "going to iterate before putting key and removing one>" + key + " with set size>" + set.size());
            while (setIterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = setIterator.next();
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
            map.remove(set.first().getKey());
            set.pollFirst();
            // currNo--;
        }
        map.put(key, new Pair(key, value, currNo));
        System.out.println("for adding key" + key + " success?" + set.add(new AbstractMap.SimpleEntry<>(key, currNo)));
        Iterator<Map.Entry<Integer, Integer>> setIterator = set.iterator();
        System.out.println("going to iterate after putting key>" + key + " with set size>" + set.size());
        System.out.println("meanwhile map entry is" + map.get(key).key + " value>" + map.get(key).value);
        while (setIterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = setIterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    static class Pair {
        int key;
        int value;
        int useCounter;

        public Pair(int key, int value, int useCounter) {
            this.key = key;
            this.value = value;
            this.useCounter = useCounter;
        }
    }

    static class SetComp implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
            int res = a.getValue().compareTo(b.getValue());
            if (res == 0) {
                return a.getKey().compareTo(b.getKey());
            }
            return res;
        }
    }

    public static void main(String[] args) {
        // ["LRUCache","put","put","get","put","get","put","get","get","get"]
        // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        obj.put(3, 3);
        System.out.println(obj.get(2));
    }
}

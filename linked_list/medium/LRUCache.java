package linked_list.medium;

//https://leetcode.com/problems/lru-cache/submissions/
import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, Node> map;
    Node left, right;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            insert(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            map.remove(key);
        }
        map.put(key, new Node(key, value));
        insert(map.get(key));
        if (map.size() > capacity) {
            map.remove(left.next.key);
            remove(left.next);
        }
    }

    public void remove(Node node) {
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node) {
        Node prevToRight = right.prev;
        prevToRight.next = node;
        node.prev = prevToRight;
        node.next = right;
        right.prev = node;
    }

    class Node {
        Node prev, next;
        int key, value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

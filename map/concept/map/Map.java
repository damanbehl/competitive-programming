package map.concept.map;

import java.util.ArrayList;

public class Map<K, V> {
    ArrayList<MapNode<K, V>> buckets;
    private int size;
    private int numBuckets;

    public Map() {
        numBuckets = 5;
        buckets = new ArrayList<>();
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
    }

    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets.get(bucketIndex);
        MapNode<K, V> newNode = new MapNode<K, V>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        double loadFactor = (1.0 * size) / numBuckets;
        if (loadFactor > 0.7) {
            rehash();
        }
    }

    private int getBucketIndex(K key) {
        // since Object class is superclass of all
        // Object class implements hashCode fn
        // but different classes have different implementations of hashCode
        // eg strings might use sum of ascii character values base p where p is prime
        int hashCode = key.hashCode();
        return hashCode % numBuckets;
    }

    public int size() {
        return size;
    }

    public V removeKey(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prevToHead = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (prevToHead == null) {
                    buckets.set(bucketIndex, head.next);
                } else {
                    prevToHead.next = prevToHead.next.next;
                }
                size--;
                return head.value;
            }
            prevToHead = head;
            head = head.next;
        }
        return null;
    }

    public V getValue(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    // to visualize internal working
    public double loadFactor() {
        return (1.0 * size) / numBuckets;
    }

    private void rehash() {
        System.out.println("Rehashing: buckets " + numBuckets + " size " + size);
        ArrayList<MapNode<K, V>> temp = buckets;
        buckets = new ArrayList<>();
        for (int i = 0; i < 2 * temp.size(); i++) {
            buckets.add(null);
        }
        size = 0;
        numBuckets *= 2;
        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                K key = head.key;
                V value = head.value;
                insert(key, value);
                head = head.next;
            }
        }
    }
}

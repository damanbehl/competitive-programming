package map.concept.map;

import java.util.ArrayList;

public class Map<K, V> {
    ArrayList<MapNode<K, V>> buckets;
    int size;
    int numBuckets;

    public Map() {
        numBuckets = 20;
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
        head = buckets.get(bucketIndex);
        MapNode<K, V> newNode = new MapNode<K, V>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
    }

    private int getBucketIndex(K key) {
        // since Object class is superclass of all
        // Object class implements hashCode fn
        // but different classes have different implementations of hashCode
        // eg strings might use sum of ascii character values base p where p is prime
        int hashCode = key.hashCode();
        return hashCode % numBuckets;
    }
}

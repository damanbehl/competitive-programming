package map.concept.treemap;

public class HNode<K, V> {
    public K key;
    public V value;
    public HNode<K, V> left;
    public HNode<K, V> right;
    public int height;
    public int balance;

    public HNode() {

    }

    public HNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.height = 0;
        this.balance = 0;
    }
}

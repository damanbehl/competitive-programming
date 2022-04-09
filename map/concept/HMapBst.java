package map.concept;

import exception.QueueEmptyException;
import queues.concept.QueueUsingLL;
import utility.Pair;

public class HMapBst<K extends Comparable<K>, V> {
    private HNode<K, V> root;

    public void put(K key, V value) {
        root = putHelper(root, key, value);
    }

    private HNode<K, V> putHelper(HNode<K, V> root, K key, V value) {
        if (root == null) {
            return new HNode<K, V>(key, value);
        }
        if (root.key.compareTo(key) == 0) {
            root.value = value;
        } else if (root.key.compareTo(key) > 0) {
            root.left = putHelper(root.left, key, value);
        } else {
            root.right = putHelper(root.right, key, value);
        }
        return getRotation(root);
    }

    public V delete(K key) {
        Pair<HNode<K, V>, V> rootNVal = deleteHelper(root, key);
        root = rootNVal.first;
        return rootNVal.second;
    }

    private Pair<HNode<K, V>, V> deleteHelper(HNode<K, V> root, K key) {
        Pair<HNode<K, V>, V> retVal = new Pair<>();
        if (root == null) {
            return retVal;
        }
        if (root.key.compareTo(key) == 0) {
            retVal.second = root.value;
            if (root.left == null) {
                retVal.first = root.right;
                return retVal;
            } else if (root.right == null) {
                retVal.first = root.left;
                return retVal;
            } else {
                HNode<K, V> node = root.right;
                while (node.left != null) {
                    node = node.left;
                }
                root.key = node.key;
                root.value = node.value;
                root.right = deleteHelper(root.right, node.key).first;
                retVal.first = root;
            }
        } else if (root.key.compareTo(key) > 0) {
            Pair<HNode<K, V>, V> temp = deleteHelper(root.left, key);
            root.left = temp.first;
            retVal.first = root;
            retVal.second = temp.second;
        } else {
            Pair<HNode<K, V>, V> temp = deleteHelper(root.right, key);
            root.right = temp.first;
            retVal.first = root;
            retVal.second = temp.second;
        }
        retVal.first = getRotation(retVal.first);
        return retVal;

    }

    public V getValue(K key) {
        return getValueHelper(root, key);
    }

    private V getValueHelper(HNode<K, V> root, K key) {
        if (root == null)
            return null;
        if (root.key.compareTo(key) < 0) {
            return getValueHelper(root.right, key);
        } else if (root.key.compareTo(key) > 0) {
            return getValueHelper(root.left, key);
        } else {
            return root.value;
        }
    }

    private HNode<K, V> getRotation(HNode<K, V> node) {
        updateHeightBalance(node);
        if (node.balance == 2) {
            if (node.left.balance == 1) {
                // LL
                return rotateRight(node);
            } else {
                // LR
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        } else if (node.balance == -2) {
            if (node.right.balance == -1) {
                // RR
                return rotateLeft(node);
            } else {
                // RL
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }

    public void updateHeightBalance(HNode<K, V> root) {
        int lh = -1;
        int rh = -1;
        if (root.left != null)
            lh = root.left.height;
        if (root.right != null)
            rh = root.right.height;
        root.balance = lh - rh;
        root.height = Math.max(lh, rh) + 1;
    }

    public HNode<K, V> rotateRight(HNode<K, V> A) {
        HNode<K, V> B = A.left;
        HNode<K, V> BRight = B.right;
        B.right = A;
        A.left = BRight;
        updateHeightBalance(A);
        updateHeightBalance(B);
        return B;
    }

    public HNode<K, V> rotateLeft(HNode<K, V> A) {
        HNode<K, V> B = A.right;
        HNode<K, V> BLeft = B.left;
        B.left = A;
        A.right = BLeft;
        updateHeightBalance(A);
        updateHeightBalance(B);
        return B;
    }

    public void printLevelWise() {
        printLevelWiseHelper(root);
        System.out.println();
    }

    private void printLevelWiseHelper(HNode<K, V> root) {
        if (root == null) {
            return;
        }
        QueueUsingLL<HNode<K, V>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);
        while (!pendingNodes.empty()) {
            HNode<K, V> front;
            try {
                front = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return;
            }
            String current = front.key.toString() + " : " + front.value.toString();
            if (front.left != null) {
                pendingNodes.enqueue(front.left);
                current += "L>" + front.left.key.toString() + " : " + front.left.value.toString() + ", ";
            }
            if (front.right != null) {
                pendingNodes.enqueue(front.right);
                current += "R>" + front.right.key.toString() + " : " + front.right.value.toString() + ", ";
            }
            System.out.println(current);
        }
    }
}

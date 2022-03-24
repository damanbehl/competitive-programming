package bst.concept;

import binary_trees.concept.BinaryTreeNode;
import binary_trees.concept.BinaryTreeUse;

public class BinarySearchTree {
    private BinaryTreeNode<Integer> root;

    public void insertData(int data) {
        insertDataHelper(data, root);
    }

    private void insertDataHelper(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            this.root = new BinaryTreeNode<Integer>(data);
            return;
        }
        if (root.data == data) {
            return;
        }
        if (data > root.data) {
            if (root.right == null) {
                root.right = new BinaryTreeNode<Integer>(data);
                return;
            } else {
                insertDataHelper(data, root.right);
                return;
            }
        } else {
            if (root.left == null) {
                root.left = new BinaryTreeNode<Integer>(data);
                return;
            } else {
                insertDataHelper(data, root.left);
            }
        }
    }

    public boolean searchData(int data) {
        return searchDataHelper(data, root);
    }

    private boolean searchDataHelper(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        if (data > root.data) {
            return searchDataHelper(data, root.right);
        } else {
            return searchDataHelper(data, root.left);
        }
    }

    public void deleteData(int data) {
        root = deleteDataHelper(root, data);
    }

    private BinaryTreeNode<Integer> deleteDataHelper(BinaryTreeNode<Integer> root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.data) {
            root.left = deleteDataHelper(root.left, key);
            return root;
        } else if (key > root.data) {
            root.right = deleteDataHelper(root.right, key);
            return root;
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                BinaryTreeNode<Integer> subRoot = root.right;
                BinaryTreeNode<Integer> prevToSub = root.right;
                while (subRoot.left != null) {
                    prevToSub = subRoot;
                    subRoot = subRoot.left;
                }
                if (subRoot.right != null && subRoot != prevToSub) {
                    prevToSub.left = subRoot.right;
                } else {
                    prevToSub.left = null;
                }
                if (subRoot != prevToSub) {
                    subRoot.right = root.right;
                }
                subRoot.left = root.left;
                return subRoot;
            }
        }

    }

    public void printBst() {
        BinaryTreeUse.printLevelWise(root);
    }
}

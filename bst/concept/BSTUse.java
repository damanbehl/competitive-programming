package bst.concept;

public class BSTUse {
    public static void main(String[] args) {
        BinarySearchTree bst1 = new BinarySearchTree();
        bst1.insertData(10);
        bst1.insertData(-1);
        bst1.insertData(12);
        bst1.insertData(24);
        bst1.insertData(11);
        bst1.printBst();
        System.out.println("Is 12 present" + bst1.searchData(12));
        bst1.deleteData(12);
        bst1.printBst();
    }
}

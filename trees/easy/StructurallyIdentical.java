package trees.easy;

import trees.concept.TreeNode;
import trees.concept.TreeUseLevelWise;

public class StructurallyIdentical {
    public static void main(String[] args) {
        System.out.println("Enter tree 1");
        TreeNode<Integer> treeOne = TreeUseLevelWise.takeInput();
        System.out.println("Enter tree 2");
        TreeNode<Integer> treeTwo = TreeUseLevelWise.takeInput();
        System.out.println(isIdentical(treeOne, treeTwo));
    }

    static boolean isIdentical(TreeNode<Integer> treeOne, TreeNode<Integer> treeTwo) {
        if (treeOne.data != treeTwo.data) {
            return false;
        }
        if (treeOne.children.size() != treeTwo.children.size()) {
            return false;
        }
        for (int i = 0; i < treeOne.children.size(); i++) {
            if (!isIdentical(treeOne.children.get(i), treeTwo.children.get(i))) {
                return false;
            }
        }
        return true;
    }
}

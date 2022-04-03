package binary_trees.easy;

//https://nados.io/question/path-to-leaf-from-root-in-range
public class PathToLeafInRange {
    public static void pathToLeafFromRoot(TreeNode node, String path, int sum, int lo, int hi) {
        if (node.left == null && node.right == null) {
            sum = sum + node.val;
            path = path + node.val;
            if (sum >= lo && sum <= hi) {
                System.out.println(path);
            }
            return;
        } else {
            String cont = path + node.val + " ";
            sum += node.val;
            if (sum > hi) {
                return;
            }
            if (node.left != null)
                pathToLeafFromRoot(node.left, cont, sum, lo, hi);
            if (node.right != null)
                pathToLeafFromRoot(node.right, cont, sum, lo, hi);
        }
    }

}

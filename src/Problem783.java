import org.learn.leetcode.easy.TreeNode;

public class Problem783 {

    public int minDiffInBST(TreeNode root) {
        return minDiffInBSTInternal(root);
    }

    private int minDiffInBSTInternal(TreeNode root) {

        if(root == null) return 0;
        int left = 0, right = 0;
        if(root.left != null) {
            left = Math.abs(root.val-root.left.val);
        }

        if(root.right != null) {
            right = Math.abs(root.val-root.right.val);

        }

        int leftSub = minDiffInBSTInternal(root.left);
        int rightSub = minDiffInBSTInternal(root.right);

        return Math.min(Math.min(left, right), Math.min(leftSub, rightSub));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(6);

        System.out.println(new Problem783().minDiffInBST(root));
    }
}

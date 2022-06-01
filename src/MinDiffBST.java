import org.learn.leetcode.easy.TreeNode;

public class MinDiffBST {

    public int minDiffInBST(TreeNode root) {

        Integer prev = null, min=Integer.MAX_VALUE;
        inorder(root, prev, min);

        return min;
    }

    private void inorder(TreeNode root, Integer prev, Integer min) {

        if(root == null) {
            return ;
        }
        inorder(root.left, prev, min);


        if(prev != null) {
            min = Math.min(min, root.val-prev);
        }
        prev = root.val;
        inorder(root.right, prev, min);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(new MinDiffBST().minDiffInBST(root));
    }
}

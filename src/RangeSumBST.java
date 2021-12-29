import org.learn.leetcode.easy.TreeNode;

public class RangeSumBST {


    int result = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSumBSTInternal(root, low, high);
    }

    private int rangeSumBSTInternal(TreeNode root, int low, int high) {

        if(root == null) {
            return 0;
        }

        if(root.val>= low && root.val<=high) {
            result+=root.val;
        }

        if(root.val> low) {
             rangeSumBSTInternal(root.left, low, high);
        }

        if(root.val<high) {
             rangeSumBSTInternal(root.right, low, high);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);

        RangeSumBST obj = new RangeSumBST();
        System.out.println(obj.rangeSumBST(root,7,15));
    }
}

import org.learn.leetcode.easy.TreeNode;

public class LongestUnivaluePath {
    int max_path;
    public int longestUnivaluePath(TreeNode root) {
        longestUnivaluePathInternal(root);
        return max_path;   
    }

    private int longestUnivaluePathInternal(TreeNode root) {

        if(root == null) {
            return 0;
        }
        int left = longestUnivaluePathInternal(root.left);
        int right = longestUnivaluePathInternal(root.right);

        if(root.left !=null && root.left.val == root.val) {
            left++;
        }

        if(root.right != null && root.right.val == root.val) {
            right++;
        }

        max_path = Math.max(max_path, left+right);
        return 1+ Math.max(left, right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);
        LongestUnivaluePath longestUnivaluePath = new LongestUnivaluePath();
        System.out.println(longestUnivaluePath.longestUnivaluePath(root));
    }
}

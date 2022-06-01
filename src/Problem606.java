import org.learn.leetcode.easy.TreeNode;

public class Problem606 {


    public String tree2str(TreeNode root) {
        if(root == null ) return "";
        StringBuilder sb = new StringBuilder();
        return  tree2Str(root);

    }

    private String tree2Str(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        if (root == null) return "";

        if(root.left == null && root.right == null) {
            sb.append(root.val);
            return sb.toString();
        }


        if (root.right == null) {
            sb.append(root.val).append("(").append(tree2Str(root.left)).append(")");
            return sb.toString();
        }

        sb.append(root.val);
        sb.append("(").append(tree2Str(root.left)).append(")");
        sb.append("(").append(tree2Str(root.right)).append(")");
        return sb.toString();

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        System.out.println(new Problem606().tree2str(root));

    }
}

public class TreeNod extends Node {

    String val;
    TreeNod left;
    TreeNod right;

    public TreeNod(String val) {
        this.val = val;
    }

    @Override
    public int evaluate() {
        return dfs(this) ;
    }

    private int dfs(TreeNod root) {
        if(root.left == null && root.right == null) {
            return Integer.valueOf(root.val);
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        if(root.val == "+") {
            return left+right;
        }else if(root.val == "-") {
            return left-right;
        }else if(root.val == "*") {
            return left*right;
        }else  {
            return left/right;
        }
    }
}

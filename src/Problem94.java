import org.learn.leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem94 {

    public List<Integer> inorderTraversal(TreeNode root) {


        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack();

        pushLeftOnStack(root, stack);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            result.add(node.val);
            pushLeftOnStack(root.right, stack);
        }

        return result;

    }

    public void pushLeftOnStack(TreeNode root, Stack<TreeNode> stack) {

        while(root != null) {

            stack.push(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        new Problem94().inorderTraversal(root);
    }
}

package org.learn.leetcode.easy;

public class UniValTree {
    public boolean isUnivalTree(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isValueSame(root.left, root.val) && isValueSame(root.right, root.val);

    }

    private boolean isValueSame(TreeNode childNode, int rootValue) {

        if (childNode == null) return true;
        if (childNode.val == rootValue) {
            return isValueSame(childNode.left, childNode.val) && isValueSame(childNode.right, childNode.val);
        }

        return false;
    }


}

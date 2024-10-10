package org.learn.leetcode.bst;

import org.learn.leetcode.easy.TreeNode;

public class ValidBst {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root, root.val, root.val);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        }
        boolean isLeft = root.left != null ? root.left.val < min && isValidBST(root.left, root.left.val, max) : true;
        boolean  isRight = root.right != null ? root.right.val > max && isValidBST(root.right,min, root.right.val ):true;

        return isLeft && isRight;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        System.out.println(new ValidBst().isValidBST(root));
    }
}

package org.learn.leetcode.easy;

public class HouseRobber {
    public int rob(TreeNode root) {

        if(root == null) return 0;

        return Math.max(Math.max(rob(root, true), rob(root.left, true)+rob(root.right, true)),Math.max(rob(root.left, true), rob(root.right, true)));

    }


    private int rob(TreeNode root, boolean shouldRob) {

        if(root == null) {
            return 0;
        }

        if(shouldRob) {
            return root.val + rob(root.left, false) + rob(root.right, false);
        }else {

            return rob(root.left, true) + rob(root.right, true);
        }


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3);

        System.out.println(new HouseRobber().rob(root));

    }
}

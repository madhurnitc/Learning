package org.learn.leetcode.medium;

import org.learn.leetcode.easy.TreeNode;

public class HouseRobber3 {


    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(rob(root,true), rob(root, false));

    }

    public int rob(TreeNode root, boolean shouldRob) {
        if(root == null) {
            return 0;
        }

        int sum = 0;
        int childSum =0;

        if(shouldRob) {

            if(root.left != null) {
                sum =  rob(root.left.left, true) + rob(root.left.right, true);
            }

            if(root.right != null) {
                sum = sum + rob(root.right.left, true) + rob(root.right.right, true);
            }
        }

        return Math.max(sum+root.val, rob(root.left, true)+rob(root.right, true));

    }
}

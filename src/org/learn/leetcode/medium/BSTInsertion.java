package org.learn.leetcode.medium;

import org.learn.leetcode.easy.TreeNode;

public class BSTInsertion {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val ) {
            root.left = insertIntoBST(root.left, val);
        }else if(root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }


        return root;
    }


}

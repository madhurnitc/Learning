package org.learn.leetcode.easy;

public class BSTSearchNonRecursive {
    public TreeNode searchBST(TreeNode current, int val) {
        while (current != null && current.val != val) {
            if (current.val < val) {
                current = current.right;
            } else if (current.val > val) {
                current = current.left;
            }
        }
        return current;
    }
}

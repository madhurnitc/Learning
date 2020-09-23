package org.learn.leetcode.easy;

import apple.laf.JRSUIUtils;

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val > R) return rangeSumBST(root.left, L, R);
        if (root.val < L) return rangeSumBST(root.right, L, R);
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);

    }
}

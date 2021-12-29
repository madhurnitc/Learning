package org.learn.leetcode.medium;

import org.learn.leetcode.easy.TreeNode;

public class BInaryTreeLongestConsecutive2 {

    int maxLength =0;
    public int longestConsecutive(TreeNode root) {


        longestConsecitiveInternal(root);
        return maxLength;
    }

    private int[] longestConsecitiveInternal(TreeNode root) {

        if(root == null) {
            return new int[]{0,0};
        }
        int inr = 1, dcr = 1;
        if(root.left != null) {

            int[] left = longestConsecitiveInternal(root.left);
            if(root.val == root.left.val+1) {
                dcr = left[1] +1;
            }else if (root.val == root.left.val-1) {
                inr = left[0] + 1;
            }
        }

        if(root.right != null) {

            int[] right = longestConsecitiveInternal(root.right);
            if(root.val == root.left.val+1) {
                dcr = Math.max(right[1]+1, dcr);
            }else if (root.val == root.right.val-1) {
                inr = Math.max(right[0]+1, inr);
            }
        }

        maxLength = Math.max(maxLength, inr+dcr -1);
        return new int[]{inr, dcr};
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        new BInaryTreeLongestConsecutive2().longestConsecutive(root);
    }
}

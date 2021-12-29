package org.learn.leetcode.medium;

import org.learn.leetcode.easy.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {


    int maxLength = 0;
    public int longestConsecutive(TreeNode root) {

        longestConsecutive(root, 0, root.val);

        return maxLength;
    }

    private void longestConsecutive(TreeNode root, int curSize, int target) {
        if(root == null) {
            return ;
        }

        if(root.val == target) {
            curSize++;
        }else {
            curSize = 1;
        }
        maxLength = Math.max(maxLength, curSize);
        longestConsecutive(root.left, curSize, root.val+1);
        longestConsecutive(root.right, curSize, root.val+1);
    }

    public static void main(String[] args) {

        TreeNode root =new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        new BinaryTreeLongestConsecutiveSequence().longestConsecutive(root);
    }
}

package org.learn.leetcode.amazon;

import org.learn.leetcode.easy.TreeNode;

public class MaximumAverageSubtree {
    Double result = 0.0;
    public double maximumAverageSubtree(TreeNode root) {

        if(root == null) {
            return result;
        }

        return averageSubTree(root);

    }

    private double averageSubTree(TreeNode root) {
        if(root == null) {
            return 0.0;
        }
        int leftSize = size(root.left);
        int rightSize = size(root.right);

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int sum = root.val + leftSum + rightSum;


        Double rootAverage = sum/(double) (leftSize+rightSize+1);
        Double leftAverage = averageSubTree(root.left);
        Double rightAverage = averageSubTree(root.right);
        Double tempMax ;
        if(leftAverage > rightAverage) {
            tempMax = leftAverage;
        }else {
            tempMax = rightAverage;
        }

        if(rootAverage > tempMax) {
            tempMax = rootAverage;
        }

        if(tempMax > result) {
            result = tempMax;
        }

        return result;
    }

    private int size(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + size(root.left) + size(root.right);
    }

    private int sum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return root.val + sum(root.left) + sum(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(1);

        new MaximumAverageSubtree().maximumAverageSubtree(root);
    }
}

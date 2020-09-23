package org.learn.leetcode.easy;

public class RangeSum {

    public int rangeSumBST(TreeNode root, int L, int R) {

        Integer result = new Integer(0);

        return rangeSumBSTInternal(root, L, R, result);

    }

    private int rangeSumBSTInternal(TreeNode root, int L, int R , Integer result) {

        if(root == null) return 0;
        if(root.val>=L && root.val<= R) {

            result = result + root.val;

        }

        if(L<root.val ) {
            rangeSumBSTInternal(root.left, L, R , result);
        }

        if (R> root.val) {
            rangeSumBSTInternal(root.right, L, R, result);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        RangeSum obj =  new RangeSum();
        System.out.println(obj.rangeSumBST(root, 7, 15));

    }
}

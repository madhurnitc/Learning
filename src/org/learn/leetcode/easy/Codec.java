package org.learn.leetcode.easy;

import apple.laf.JRSUIUtils;

public class Codec {


    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        return serialize(root, "");
    }

    private String serialize(TreeNode root, String result) {

        if(root == null) {
            result = result + "#";
        }else {
            result = result +  root.val + ",";
            result =  serialize(root.left, result);
            result =  serialize(root.right, result);
        }

        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {


        return null;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);
        System.out.println(new Codec().serialize(root));
    }
}

package org.learn.leetcode.medium;

import org.learn.leetcode.easy.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return result;
        }
        TreeNode curr = root;
        q.offer(curr);

        while( !q.isEmpty()) {
            int level = q.size();
            List<Integer> temp = new LinkedList<>();
            for(int i =0; i<level; i++) {
                TreeNode node = q.remove();
                temp.add(node.val);
                if(node.left != null) {
                    q.add(node.left);
                }

                if(node.right  != null) {
                    q.add(node.right);
                }
            }
            result.add(temp);
        }

        return result;
    }
}

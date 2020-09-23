package org.learn.leetcode.medium;

import org.learn.leetcode.easy.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Node curr = root;
        q.offer(curr);
        while(!q.isEmpty()) {
            int level = q.size();
            List<Integer> list = new LinkedList<>();
            for  (int i =0; i<level; i++) {
                Node temp = q.remove();
                list.add(temp.val);
                for(Node child : temp.children) {
                    q.add(child);
                }
            }
            result.add(list);
        }

        return result;
    }

}

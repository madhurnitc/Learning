package org.learn.leetcode.amazon;

import org.learn.leetcode.easy.TreeNode;

import java.util.*;

public class AllNodeAtDistanceK {

    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        annotateParent(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        int distance = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            if (distance == K) {
                List<Integer> list = new ArrayList<>();
                while(! queue.isEmpty()) {
                    list.add(queue.poll().val);
                }
                return list;
            } else  {
                for(int i = 0; i<size; i++) {
                    TreeNode node = queue.poll();
                    if(node.left != null && !seen.contains(node.left)) {
                        seen.add(node.left);
                        queue.offer(node.left);
                    }

                    if(node.right != null && !seen.contains(node.right)) {
                        seen.add(node.right);
                        queue.offer(node.right);
                    }

                    if( parentMap.get(node) != null && !seen.contains(parentMap.get(node))) {
                        seen.add(parentMap.get(node));
                        queue.add(parentMap.get(node));
                    }
                }

            }
            distance++;
        }

        return new ArrayList<>();
    }

    public void annotateParent(TreeNode child, TreeNode parent) {
        if(child != null) {
            parentMap.put(child, parent);
            annotateParent(child.left, child);
            annotateParent(child.right, child);
        }

    }
}

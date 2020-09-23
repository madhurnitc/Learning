package org.learn.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePreOrderTraversal {
    public List<Integer> preorder(Node root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        return preOrderInternal(root, result);

    }

    private List<Integer> preOrderInternal(Node root, List<Integer> result) {

        if (root != null) {

            result.add(root.val);

            for (Node child : root.children) {
                preOrderInternal(child, result);
            }
        }

        return result;
    }


}

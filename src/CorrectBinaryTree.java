import javafx.util.Pair;
import org.learn.leetcode.easy.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CorrectBinaryTree {


    public TreeNode correctBinaryTree(TreeNode root) {

        if(root == null) {
            return root;
        }
        Set<Integer> seen = new HashSet<>();

        Queue<Pair<TreeNode, TreeNode>> q = new LinkedList<>();
        q.offer(new Pair<>(root, null));
        seen.add(root.val);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size; i++) {
                Pair<TreeNode, TreeNode> node = q.poll();
                TreeNode curr = node.getKey();
                TreeNode parent = node.getValue();
                if(curr.right != null && seen.contains(curr.right.val)) {
                    if(parent.left == curr) {
                        parent.left = null;
                    }else {
                        parent.right = null;
                    }

                    return root;
                }
                if(curr.right != null) {
                    q.offer(new Pair<>(curr.right, curr));
                    seen.add(curr.right.val);
                }

                if(curr.left != null) {
                    q.offer(new Pair<>(curr.left, curr));
                    seen.add(curr.left.val);
                }

            }

        }

        return root;

    }

    public static void main(String[] args) {
        new CorrectBinaryTree().correctBinaryTree(null);
    }
}

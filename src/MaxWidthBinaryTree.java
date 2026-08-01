import org.learn.leetcode.easy.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthBinaryTree {

    public static class NodePos {
        TreeNode node;
        int pos;
        public NodePos(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }
    public Integer maxWidth(TreeNode root) {
        if(root == null) return 0;

        Queue<NodePos> q = new LinkedList<>();
        q.offer(new NodePos(root, 0));
        int maxWidth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int leftPos = q.peek().pos;
            int rightPos = -1;
            for(int i = 0; i < size; i++) {
                NodePos nodePos = q.poll();
                TreeNode node = nodePos.node;
                int pos = nodePos.pos;
                if (i == size - 1) {
                    rightPos = pos;
                }
                if(node.left != null) {
                    q.offer(new NodePos(node.left, 2*pos-1));
                }
                if(node.right != null) {
                    q.offer(new NodePos(node.right, 2*pos+1));
                }
            }
            maxWidth = Math.max(maxWidth, rightPos - leftPos+1);
        }
        return maxWidth;
    }
}

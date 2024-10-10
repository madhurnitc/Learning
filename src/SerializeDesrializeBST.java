import org.learn.leetcode.easy.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDesrializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);

        return sb.toString();

    }

    private StringBuilder serialize(TreeNode root, StringBuilder sb) {

        if(root == null) {
            return sb;
        }
        sb.append(root.val);
        sb.append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);

        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<Integer> queue = new LinkedList<>();
        for(String num : data.split(",")) {
            queue.offer(Integer.valueOf(num));
        }

        TreeNode root = constructBST(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);

        return root;
    }

    private TreeNode constructBST(Queue<Integer> queue, int minValue, int maxValue) {

        if(queue.isEmpty()) {
            return null;
        }

        int val = queue.peek();
        if(val < minValue || val > maxValue) {
            return null;
        }
        queue.poll();
        TreeNode root = new TreeNode(val);
        root.left = constructBST(queue, minValue, val);
        root.right = constructBST(queue, val, maxValue);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        String s = new SerializeDesrializeBST().serialize(root);
        root = new SerializeDesrializeBST().deserialize(s);
        System.out.println("Running Main Program");


		
        System.out.println("####");
    }
}

package org.learn.leetcode.amazon;

import org.learn.leetcode.easy.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBnaryTree {


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            if (root == null) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            sb.append(root.val);
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sb.append(",");
                    if(node.left != null) {
                        sb.append(node.left.val);
                        queue.offer(node.left);
                    }else {
                        sb.append("#");
                    }
                    sb.append(",");
                    if(node.right != null) {
                        sb.append(node.right.val);
                        queue.offer(node.right);
                    }else {
                        sb.append("#");
                    }

                }
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            if(data == null || data.length() == 0) {
                return null;
            }
            String[] nodes = data.split(",");
            
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int idx = 1;
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(!nodes[idx].equals("#")) {
                    node.left = new TreeNode(Integer.parseInt(nodes[idx]));
                    queue.offer(node.left);
                }

                if(!nodes[idx+1].equals("#")) {
                    node.right = new TreeNode(Integer.parseInt(nodes[idx+1]));
                    queue.offer(node.right);
                }

                idx= idx+2;
            }

            return root;
        }

        private TreeNode constructTree(TreeNode root, int parent, String[] nodes) {
            if (nodes[parent].charAt(0) == '#') {
                return null;
            }
            TreeNode child = new TreeNode(Integer.parseInt(nodes[parent]));
            child.left = constructTree(root, 2*parent+1, nodes);
            child.right = constructTree(root, 2*parent + 2, nodes);
            return child;
        }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        SerializeAndDeserializeBnaryTree  obj = new SerializeAndDeserializeBnaryTree();
        String serialize = obj.serialize(root);
        System.out.println(serialize);

        TreeNode newRoot = obj.deserialize(serialize);
    }

}

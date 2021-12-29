import org.learn.leetcode.easy.TreeNode;

import java.util.*;

public class Problem863 {
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        annotateParent(root, null);
        Set<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        int distance  = 0;
        while( !queue.isEmpty()) {
            int size = queue.size();
            if(distance == k) {
                break;
            }else {
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

                    if(parentMap.get(node) != null && !seen.contains(parentMap.get(node))) {
                        seen.add(parentMap.get(node));
                        queue.offer(parentMap.get(node));
                    }
                }
            }
            distance++;
        }

        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
    }

    private void annotateParent(TreeNode child, TreeNode parent) {

        if(child != null) {
            parentMap.put(child, parent);
            annotateParent(child.left, child);
            annotateParent(child.right, child);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        new Problem863().distanceK(root, root.left, 2);
    }
}

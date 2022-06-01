import org.learn.leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem365FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        findHeight(root, result);
        return result;
    }

    private int  findHeight(TreeNode root, List<List<Integer>> result) {
        if(root == null) {
            return -1;
        }

        int level = 1 + Math.max(findHeight(root.left, result), findHeight(root.right, result));
        if(result.size() < level +1) result.add(new ArrayList<>());
        result.get(level).add(root.val);
        return level;
    }
}

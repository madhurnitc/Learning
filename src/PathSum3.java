import java.util.HashMap;
import java.util.Map;

import org.learn.leetcode.easy.TreeNode;

public class PathSum3 {
    int count =0;
    int target;
    Map<Long, Long> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        preorder(root, 0L);
        return count;
    }
    private void preorder(TreeNode root, long currSum) {
       if(root == null){
        return ;
       }

       currSum+= root.val;
       if(currSum == k){
        count++;
       }

       count+=map.getOrDefault(currSum-target, 0L);
       map.put(currSum, map.getOrDefault(currSum, 0L)+1L);
       preorder(root.left, currSum);
       preorder(root.right, currSum);

    }
}

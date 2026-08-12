import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSum(root, targetSum, result, path);
        return result.stream().map(l->l.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }

    private void pathSum(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path) {

        if(root == null){
            return ;
        }
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum == root.val){
                result.add(new ArrayList<>(path));
            }
        }

        pathSum(root.left, targetSum-root.val, result, path);
        pathSum(root.right, tatgetSum-root.val, result, path);
        path.remove(path.size()-1);
    }
}

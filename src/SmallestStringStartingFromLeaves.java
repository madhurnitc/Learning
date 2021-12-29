import org.learn.leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestStringStartingFromLeaves {

    public String smallestFromLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, list, "");

        Collections.sort(list);

        String result = list.get(0);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<result.length(); i++) {
            char c = (char)('a' + result.charAt(i)-'0');
            sb.append(c);
        }
        return sb.toString();

    }

    public void dfs(TreeNode root, List<String> list, String path) {

        if(root == null) {
            return ;
        }
        path=root.val+path;
        if(root.left == null && root.right == null) {
            list.add(path);
            return ;
        }

        dfs(root.left, list, path);
        dfs(root.right, list, path);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        SmallestStringStartingFromLeaves obj = new SmallestStringStartingFromLeaves();
        System.out.println(obj.smallestFromLeaf(root));
    }
}

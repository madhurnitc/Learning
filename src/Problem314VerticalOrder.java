import org.learn.leetcode.easy.TreeNode;

import java.util.*;

public class Problem314VerticalOrder {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;

        }
        Map<Integer,List<Integer>> columnList = new HashMap<>();
        Queue<Column> q =new LinkedList<>();
        int level = 0;
        q.offer(new Column(0, root));
        int minCol =0, maxCol = 0;
        while(!q.isEmpty()) {
            Column column = q.poll();
            columnList.computeIfAbsent(column.col, e->new ArrayList<Integer>());
            columnList.get(column.col).add(column.node.val);

            minCol = Math.min(minCol, column.col);
            maxCol = Math.max(maxCol, column.col);
            if(column.node.left != null) {
                q.offer(new Column(column.col-1, column.node.left));
            }
            if(column.node.right!= null) {
                q.offer(new Column(column.col+1, column.node.right));
            }

        }
        for(int i = minCol; i<=maxCol; i++) {
            result.add(columnList.get(i));
        }

        return result;
    }

    public class Column {
        int col;
        TreeNode node;
        public Column(int col, TreeNode node) {
            this.col = col;
            this.node = node;
        }
    }
}

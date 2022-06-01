import org.learn.leetcode.easy.TreeNode;

import java.util.Stack;

public class ContructBinaryTreeFromString {
    public TreeNode str2tree(String s) {

        if(s == null || s.isEmpty()) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0, j = i; i<s.length(); i++, j=i) {
            char c = s.charAt(i);
            if(c ==')') {
                stack.pop();

            }else if(c >='0' && c<='9' || c == '-') {
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))) {
                    i++;
                }
                int nodeValue = Integer.valueOf(s.substring(j,i+1));
                TreeNode node = new TreeNode(nodeValue);
                if(!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if(parent.left != null) {
                        parent.right = node;
                    }else {
                        parent.left = node;
                    }
                }

                stack.push(node);
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        String  s = "4(2(3)(1))(6(5))";

        TreeNode root = new ContructBinaryTreeFromString().str2tree(s);
        System.out.println("SSSSS");
    }
}

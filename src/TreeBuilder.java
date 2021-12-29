import java.util.Stack;

public class TreeBuilder {

    Node buildTree(String[] postfix) {
        Stack<TreeNod> stack = new Stack<>();
        for(String val : postfix) {
            TreeNod node = new TreeNod(val);
            if(isOperator(val)) {
                TreeNod right = stack.pop();
                TreeNod left = stack.pop();
                node.left = left;
                node.right = right;
            }
            stack.push(node);
        }
        return stack.pop();
    }

    private boolean isOperator(String val) {

        return val == "+" || val == "-" || val == "*" || val == "/";
    }
}

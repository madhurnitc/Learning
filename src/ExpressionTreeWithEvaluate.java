import java.util.Stack;

public class ExpressionTreeWithEvaluate {

    public static void main(String[] args) {
        String[] postfix = {"3","4","+","2","*","7","/"};
        TreeBuilder builder = new TreeBuilder();
        Node root = builder.buildTree(postfix);
        System.out.println(root.evaluate());
    }
}

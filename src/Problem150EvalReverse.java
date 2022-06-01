import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class Problem150EvalReverse {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
        operations.put("/", (a,b)->a/b);
        operations.put("*", (a,b)->a*b);
        operations.put("+", (a,b)->a+b);
        operations.put("-", (a,b)->a-b);

        for(String token : tokens) {

            if(!operations.containsKey(token)){
                stack.push(Integer.valueOf(token));
                continue;
            }

            int num2 = stack.pop();
            int num1 = stack.pop();
            int result = operations.get(token).apply(num1, num2);
            stack.push(result);
        }

        return stack.pop();

    }
}

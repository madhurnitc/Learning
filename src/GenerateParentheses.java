import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

/*  base case
    if(string length == 2*n) {
        add(string);
        return;
    }
    //recursive case
    add a “(“
    add a “)"

    Let’s add in constraints now.
    We need to interpret the meanings of constraints.
    First, the first character should be “(“. Second, at each step, you can either print “(“ or “)”, but print “)” only when there are more “(“s than “)”s.
    Stop printing out “(“ when the number of “(“ s hit n. The first actually merges into the second condition.

 */


    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        generateParenthesis(n,result, new StringBuilder(), 0, 0);
        return result;
    }

    private void generateParenthesis(int n, List<String> result, StringBuilder stringBuilder, int openCount, int closedCount) {

        if(stringBuilder.length() == 2*n) {
            result.add(stringBuilder.toString());
            return;
        }

        if( openCount < n) {
            stringBuilder.append("(");
            generateParenthesis(n, result, stringBuilder ,openCount+1, closedCount);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if(openCount > closedCount) {
            stringBuilder.append(")");
            generateParenthesis(n, result, stringBuilder ,openCount, closedCount+1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}

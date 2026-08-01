import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stringstack = new Stack<>();
        Stack<Integer> numberstack = new Stack<>();
        String currString = "";
        int currNumber = 0;
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)=='['){
                stringstack.push(currString);
                numberstack.push(currNumber);
                currString ="";
                currNumber = 0;
            }else if(s.charAt(i)==']'){
                int num = numberstack.pop();
                String prevString = stringstack.pop();
                currString = prevString + currString.repeat(num);
            }else if (Character.isDigit(s.charAt(i))){
                currNumber = currNumber*10 + s.charAt(i)-'0';
            }else {
                currString = currString+s.charAt(i);
            }
        }

        return currString;
    }




}

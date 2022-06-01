import java.util.ArrayList;
import java.util.List;

public class Problem784 {


    public List<String> letterCasePermutation(String s) {

        if( s== null || s.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        addPerms(s.toCharArray(), result , 0);

        return result;
    }

    private void addPerms(char[] chars, List<String> result, int start){
        if(start ==chars.length) {

            result.add(new String(chars));
            return;
        }

        // if this is digit, skip to next
        if(!Character.isLetter(chars[start])){
            addPerms(chars, result, start+1);
            return ;
        }

        chars[start] = Character.toLowerCase(chars[start]);
        addPerms(chars, result, start+1);

        chars[start] = Character.toUpperCase(chars[start]);
        addPerms(chars, result, start+1);


    }
}

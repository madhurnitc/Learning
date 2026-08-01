import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    Map<Integer, Integer> memo = new HashMap<>();

    public int numDecodings(String s) {

        return numDecodings(s, 0);

    }

    private int numDecodings(String string, int index){

        if (index == string.length()){
            return 1;
        }

        if (memo.containsKey(index)){
            return memo.get(index);
        }
        if (string.charAt(index) == '0'){
            return 0;
        }


        if (index == string.length() - 1) {
            return 1;
        }
        int ans = numDecodings(string, index+1);
        if(Integer.parseInt(string.substring(index, index +2)) <=26 ) {
            ans += numDecodings(string, index+2);
        }

        memo.put(index, ans);
        return ans;

    }

}

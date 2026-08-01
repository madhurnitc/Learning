import java.util.HashMap;
import java.util.Map;

public class LongestRepeactingCharWithReplacement {

    public Integer characterReplacement(String s, Integer k) {
       int start =0;
       int maxFreq =0;
       int maxLenth = 0;
       Map<Character,Integer> map = new HashMap<>();

       for(int end=0; end<s.length();end++){
           map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0)+1);
           maxFreq = Math.max(maxFreq,map.get(s.charAt(end)));
           while((end-start+1)-maxFreq > k){
               char ch = s.charAt(start);
               map.put(ch,map.getOrDefault(ch,0)-1);
               start++;
           }
           maxLenth = Math.max(maxLenth,end-start+1);

       }
       return maxLenth;
    }
}

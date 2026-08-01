
import java.util.HashMap;
import java.util.Map;


public class LongestCharacterWithReplacement {
    public Integer characterReplacement(String s, Integer k) {
      
        Map<Character, Integer> map = new HashMap<>();
        int start =0;
        int maxLength = 0;
        int maxFreq = 0;
        for(int end =0; end<s.length(); end++) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(end)));
            if(end - start + 1 - maxFreq > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}

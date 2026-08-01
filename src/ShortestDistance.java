import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestDistance {

    Map<String, List<Integer>> map = new HashMap<>();
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int idx =0;
        for(String word: wordsDict) {
            map.computeIfAbsent(word, k -> new ArrayList<>()).add(idx);
        }

        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int i=0;
        int j = 0;
        int minDistance = Integer.MAX_VALUE;
        while(i<list1.size() && j <list2.size()){
            int idx1 = list1.get(i);
            int idx2 = list2.get(j);
            minDistance = Math.min(minDistance, Math.abs(idx1-idx2));
            if(idx1<idx2){
                i++;
            }else {
                j++;
            }

        }

        return minDistance;
    }

    public static void main(String[] args) {
        new ShortestDistance().shortestDistance(new String[] {"practice", "makes", "perfect", "coding", "makes"}, "coding","practice");
    }
}

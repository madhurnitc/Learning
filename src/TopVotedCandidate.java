import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TopVotedCandidate {
    TreeMap<Integer, Integer> treeMap;
    public TopVotedCandidate(int[] persons, int[] times) {
        treeMap = new TreeMap<>();
        int[] count = new int[persons.length];

        int lead = -1;
        for(int i = 0; i< persons.length; i++) {
            count[persons[i]]++;
            if(count[persons[i]] >= lead) {
                lead = count[persons[i]];
                treeMap.put(times[i], persons[i]);
            }
        }
    }

    public int q(int t) {
        return treeMap.floorEntry(t).getValue();
    }


    public static void main(String[] args) {
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate obj = new TopVotedCandidate(persons, times);
        System.out.println(obj.q(3));
        System.out.println(obj.q(12));
        System.out.println(obj.q(25));
        System.out.println(obj.q(15));
        System.out.println(obj.q(24));
        System.out.println(obj.q(8));
    }
}

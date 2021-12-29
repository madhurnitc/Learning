import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class FirstUnique {


    Set<Integer> firstUnique;
    Map<Integer, Boolean> uniqueMap ;
    public FirstUnique(int[] nums) {

        firstUnique = new LinkedHashSet<>();
        uniqueMap = new HashMap<>();
        for(int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {

        if(!firstUnique.isEmpty()) {
            return firstUnique.iterator().next();
        }

        return -1;
    }

    public void add(int value) {

        if(!uniqueMap.containsKey(value)) {
            uniqueMap.put(value, true);
            firstUnique.add(value);
        }else if (uniqueMap.get(value)){
            uniqueMap.put(value, false);
            firstUnique.remove(value);
        }
    }
}

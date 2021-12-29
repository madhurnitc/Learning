import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class TwoSum3 {

    Map<Integer, Integer> map ;
    public TwoSum3() {

        map = new TreeMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, 1+map.getOrDefault(number,0));
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int complement = value - entry.getKey();
            if(complement != entry.getKey()) {
                if (map.containsKey(complement)) {
                    return true;
                }
            }else {
                if(entry.getValue() > 1) {
                    return true;
                }
            }
        }

        return false;
    }
}

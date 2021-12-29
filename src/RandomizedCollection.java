import java.util.*;

public class RandomizedCollection {
    Map<Integer, LinkedHashSet<Integer>> map;
    List<Integer> list;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {

        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {

        boolean containsKey = map.containsKey(val) && map.get(val).size() != 0;
        if(!containsKey) {
            map.put(val, new LinkedHashSet<>());
        }

        list.add(val);
        map.get(val).add(list.size()-1);
        return !containsKey;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {

        boolean containsKey = map.containsKey(val) && map.get(val).size() !=0;
        if(!containsKey) {
            return false;
        }
        int remove_idx = map.get(val).iterator().next();
        if(remove_idx == list.size()-1) {
            list.remove(remove_idx);
            map.get(val).remove(remove_idx);
        }else {
            int last = list.get(list.size()-1);
            map.get(val).remove(remove_idx);
            list.set(remove_idx, last);
            map.get(last).add(remove_idx);
            map.get(last).remove(list.size()-1);
            list.remove(list.size()-1);
        }

        return true;

    }

    /** Get a random element from the collection. */
    public int getRandom() {

        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection rc = new RandomizedCollection();
        System.out.println(rc.insert(4));
        System.out.println(rc.insert(3));
        System.out.println(rc.insert(4));
        System.out.println(rc.insert(2));
        System.out.println(rc.insert(4));
        System.out.println(rc.remove(4));
        System.out.println(rc.remove(3));
        System.out.println(rc.remove(4));
        System.out.println(rc.remove(4));

    }
}

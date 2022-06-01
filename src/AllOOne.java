import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOOne {

    Bucket head;
    Bucket tail;
    Map<String, Integer> keyCountMap ;
    Map<Integer, Bucket> countBucketMap;

    public AllOOne() {
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        keyCountMap = new HashMap<>();
        countBucketMap = new HashMap<>();
    }
    public void inc(String key) {

        if(keyCountMap.containsKey(key)){
            changeKey(key, 1);
        }else {
            keyCountMap.put(key, 1);
            if(head.next.count != 1) {
                addBucketAfter(new Bucket(1), head);
            }
            head.next.keys.add(key);
            countBucketMap.put(1, head.next);

        }

    }

    private void addBucketAfter(Bucket newBucket, Bucket prevBucket) {

        newBucket.next = prevBucket.next;
        newBucket.prev= prevBucket;
        prevBucket.next.prev = newBucket;
        prevBucket.next = newBucket;


    }

    private void changeKey(String key, int offset) {
        int count = keyCountMap.get(key);
        keyCountMap.put(key, count + offset);
        Bucket currentBucket = countBucketMap.get(count);
        Bucket newBucket ;
        if(countBucketMap.containsKey(count+offset)){
            newBucket = countBucketMap.get(count + offset);
        }else {
            newBucket = new Bucket(count + offset);
            countBucketMap.put(count+offset, newBucket);
            addBucketAfter(newBucket, offset == 1 ? currentBucket : currentBucket.prev);
        }
        newBucket.keys.add(key);
        removeFromBucket(currentBucket, key);
    }

    private void removeFromBucket(Bucket currentBucket, String key) {
        currentBucket.keys.remove(key);
        if(currentBucket.keys.size() == 0){
            countBucketMap.remove(currentBucket.count);
            removeBucketFromList(currentBucket);
        }
    }

    private void removeBucketFromList(Bucket currentBucket) {

        currentBucket.prev.next = currentBucket.next;
        currentBucket.next.prev = currentBucket.prev;
        currentBucket.next = null;
        currentBucket.prev = null;
    }

    public void dec(String key) {

        int count = keyCountMap.get(key);
        if(count == 1){
            keyCountMap.remove(key);
            removeFromBucket(countBucketMap.get(count),key);
        }else {
            changeKey(key, -1);
        }

    }

    public String getMaxKey() {

        return tail.prev == head ? "" : tail.prev.keys.iterator().next();

    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    public class Bucket {

        int count ;
        Set<String> keys;
        Bucket prev;
        Bucket next;

        public Bucket(int count) {
            this.count = count;
            keys= new HashSet<>();
        }
    }

    public static void main(String[] args) {
        AllOOne one = new AllOOne();
        one.inc("hello");
        one.inc("goodbye");
        one.inc("hello");
        one.inc("hello");
        System.out.println(one.getMaxKey());
        one.inc("leet");
        one.inc("code");
        one.inc("leet");
        one.dec("hello");
        one.inc("leet");
        one.inc("code");
        one.inc("code");
        System.out.println(one.getMaxKey());


    }
}

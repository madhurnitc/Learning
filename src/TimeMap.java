import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {


    Map<String, List<ValueTimeStamp>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,  new ArrayList<ValueTimeStamp>());
        map.get(key).add(new ValueTimeStamp(timestamp, value));

    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        List<ValueTimeStamp> values = map.get(key);
        int lo = 0;
        int hi = values.size()-1;
        ValueTimeStamp returnValue = null;
        while(lo<=hi) {

            int mid = lo + (hi-lo)/2;
            ValueTimeStamp midNode = values.get(mid);
            if(midNode.time == timestamp) {
                return midNode.value;
            }else if (midNode.time > timestamp){
                hi = mid - 1;
            }else {
                returnValue = midNode;
                lo = mid+1;
            }
        }

        return returnValue.value;

    }

    public class ValueTimeStamp {
        int time;
        String value;

        public ValueTimeStamp(int time, String value){
            this.time = time;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        TimeMap map = new TimeMap();

        map.set("foo","bar",1);
        map.get("foo",1);
        map.get("foo",3);
        map.set("foo","bar2",4);
        map.get("foo",4);
        map.get("foo",5);
    }
}

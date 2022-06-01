import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem635 {

    private Map<String, Integer> t ;
    private TreeMap<String,List<Integer>> log;

    private String min  = "2000:00:00:00:00:00";
    private String max  = "2017:12:31:23:59:59";

    //2016:01:01:01:01:01
    public Problem635() {

        t = new HashMap<>();
        log = new TreeMap<>();
        t.put("Year", 4);
        t.put("Month", 7);
        t.put("Day", 10);
        t.put("Hour", 13);
        t.put("Minute", 16);
        t.put("Second", 19);


    }

    public void put(int id, String timestamp) {

        log.computeIfAbsent(timestamp, e->new ArrayList<>());
        log.get(timestamp).add(id);

    }

    public List<Integer> retrieve(String start, String end, String granularity) {

        int index = t.get(granularity);
        List<Integer> result = new ArrayList<>();
        Map<String, List<Integer>> submap = log.subMap(
                start.substring(0, index) + min.substring(index), true,
                end.substring(0, index)+ max.substring(index), true
        );

        Stream<Integer> integerStream = submap.values().stream().flatMap(Collection::stream);
        List<Integer> collect = integerStream.collect(Collectors.toList());
        return collect;

    }

    public static void main(String[] args) {
        Problem635 obj = new Problem635();

        obj.put(1,"2017:01:01:23:59:59");
        obj.put(2,"2017:01:01:22:59:59");
        obj.put(3,"2016:01:01:00:00:00");
        obj.put(4,"2016:01:01:00:00:00");
        obj.put(5,"2016:01:01:00:00:00");

        obj.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year");
        obj.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour");
    }
}



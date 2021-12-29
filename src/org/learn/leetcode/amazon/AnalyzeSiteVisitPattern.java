package org.learn.leetcode.amazon;

import java.util.*;

public class AnalyzeSiteVisitPattern {


    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        Map<String, Record> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < website.length ; i++) {
            Record record = map.getOrDefault(website[i], new Record());
            record.webSiteName = website[i];
            record.timeStamp = timestamp[i];
            record.users.add(username[i]);
            map.put(website[i], record);
        }
        PriorityQueue<Record> pq = new PriorityQueue<>(new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {

                int hits1 = map.get(o1.webSiteName).users.size();
                int hits2 = map.get(o2.webSiteName).users.size();
                int compare = hits2- hits1;

                if (compare == 0) {
                    int lastVisit = Integer.compare(o1.timeStamp, o2.timeStamp);
                    if (lastVisit == 0) {
                        return o1.webSiteName.compareTo(o2.webSiteName);
                    }

                    return lastVisit;
                }

                return compare;
            }
        });

        pq.addAll(map.values());
        int k = 3;
        while (k>0) {
            result.add(pq.poll().webSiteName);
            k--;
        }

        return result;
    }

    public class Record  {
        String webSiteName ;
        int timeStamp;
        Set<String> users;

        public Record() {
            this.users = new HashSet<>();
        }


    }

    public static void main(String[] args) {
       String[] user  = new String[] {"u1","u1","u1","u2","u2","u2"};
       int[] timeStamp = new int[] {1,2,3,4,5,6};
       String[] webSite = new String[] {"a","b","a","a","b","c"};

       new AnalyzeSiteVisitPattern().mostVisitedPattern(
               user,
               timeStamp,
               webSite
       );
    }
}

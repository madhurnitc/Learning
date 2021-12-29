package org.learn.leetcode.amazon;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Record> pq = new PriorityQueue<>(new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {

                if(o1.count == o2.count) {
                    return o1.word.compareTo(o2.word);
                }
                return Integer.compare(o2.count, o1.count );
            }
        });
        for(String word : words) {
            map.put(word, map.getOrDefault(word,0)+1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            Record r = new Record(entry.getKey(), entry.getValue());
            pq.offer(r);
        }

        while (k>0) {
            result.add(pq.poll().word);
            k--;
        }

        return result;

    }

    public class Record {
        String word;
        int count;

        public Record(String word, int count) {
            this.word = word;
            this.count = count;
        }

    }
}

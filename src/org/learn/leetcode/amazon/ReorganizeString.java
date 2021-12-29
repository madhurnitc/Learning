package org.learn.leetcode.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {


    public String reorganizeString(String S) {

        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b)-map.get(a));

        for(char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        maxHeap.addAll(map.keySet());

        while(!maxHeap.isEmpty()) {

            char first = maxHeap.remove();
            char second = maxHeap.remove();
            sb.append(first);
            sb.append(second);
            map.put(first, map.get(first)-1);
            map.put(second, map.get(second)-1);
            if(map.get(first) >0 ) {
                maxHeap.offer(first);
            }

            if(map.get(second) >0 ) {
                maxHeap.offer(second);
            }
        }

        if(!maxHeap.isEmpty()) {
            char c = maxHeap.remove();
            if(map.get(c) > 1) {
                return "";
            }
            sb.append(c);
        }

        return sb.toString();
    }

}

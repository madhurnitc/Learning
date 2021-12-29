package org.learn.leetcode.amazon;

import java.util.*;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o2.count, o1.count);
            }
        });
        HashMap<String , Integer> map = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        String[] words = paragraph.split(" ");
        for(String word :banned) {
            bannedSet.add(word);
        }
        for(String word :words) {
            if(!bannedSet.contains(word)){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue()));
        }

        return pq.poll().word;


    }
    public class Node {
        String word;
        int count;
        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }


    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        new MostCommonWord().mostCommonWord(paragraph,banned);
    }
}

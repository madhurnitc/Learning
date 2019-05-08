package org.learn.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ReconstructQueueByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){

            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] != p2[0]? Integer.compare(p2[0], p1[0]) : Integer.compare(p1[1], p2[1]);
            }
        });

        List<int[]> list = new LinkedList<>();
        for (int[] ppl: people) list.add(ppl[1], ppl);
        return list.toArray(new int[people.length][] );
    }


    public static void main(String[] args) {
        int[][] input = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        new ReconstructQueueByHeight().reconstructQueue(input);
    }
}

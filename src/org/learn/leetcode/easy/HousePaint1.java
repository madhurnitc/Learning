package org.learn.leetcode.easy;

public class HousePaint1 {

    public int minCost(int[][] costs) {

        int cost = 0;
        int index = -1;
        for (int i = 0; i < costs.length; i++) {
            index = findIndex(costs[i], index);
            cost = cost + costs[i][0];
        }
        return cost;
    }

    private int findIndex(int[] costs, int prevIndex) {
        int minimum = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < costs.length; i++) {

            if (costs[i] < minimum && i != prevIndex) {
                minimum = costs[i];
                index = i;
            }
        }

        return index;
    }
}

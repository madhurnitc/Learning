package org.learn.leetcode.easy;

import java.util.*;

public class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean isPresent = map.containsKey(val);
        if (!isPresent) {
            list.add(val);
            map.put(val, list.size() - 1);
        }

        return !isPresent;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        boolean isPresent = map.containsKey(val);
        if (isPresent) {
            int index = map.get(val);
            if (index == list.size() - 1) {
                list.remove(index);
            } else {
                // get the value of swapped item;
                int swapItem = list.get(list.size() - 1);
                Collections.swap(list, index, list.size() - 1);
                list.remove(list.size() - 1);
                map.put(swapItem, index);
            }

            map.remove(val);
        }

        return isPresent;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int max = list.size();
        int min = 0;
        int ind = (int) (Math.random() * (max - min) + min);
        return list.get(ind);
    }

    public static void main(String[] args) {

        RandomizedSet test = new RandomizedSet();

        test.insert(0);
        test.insert(1);
        test.remove(0);
        test.insert(2);
        test.remove(1);
        test.getRandom();
    }
}


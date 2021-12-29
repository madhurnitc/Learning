package org.learn.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int size = nums.length;
        UF uf = new UF(nums);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i<size; i++) {

            if(map.containsKey(nums[i])) {
                continue;
            }

            map.put(nums[i], i);
            if(map.containsKey(nums[i]-1)) {
                uf.union(i, map.get(nums[i]-1));
            }

            if(map.containsKey(nums[i]+1)) {
                uf.union(i, map.get(nums[i]+1));
            }

        }

        return uf.getMaxSize();

    }


    public class UF {

        int[] list;
        int[] size;
        int maxSize = 0;
        public UF (int[] nums) {
            this.list = new int[nums.length];
            for(int  i = 0; i<nums.length; i++) {
                list[i] = i;
            }
            if(nums != null || nums.length>0) {
                maxSize = 1;
            }
            this.size = new int[nums.length];
            Arrays.fill(this.size, 1);
        }

        public int root(int i) {
            while(i != list[i]) {
                i = list[i];
            }

            return i;
        }

        public void union(int i, int j) {
            int iroot = root(i);
            int jroot = root(j);

            if(size[iroot] >size[jroot] ) {
                list[jroot] = iroot;
                size[iroot] = size[iroot] + size[jroot];
                maxSize = Math.max(maxSize, size[iroot]);
            }else {
                list[iroot] = jroot;
                size[jroot] = size[jroot] + size[iroot];
                maxSize = Math.max(maxSize, size[jroot]);
            }
        }

        public boolean isConnected(int i , int j) {
            return root(i) == root(j);
        }

        public int getMaxSize() {
            return maxSize;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {};

        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
    }
}

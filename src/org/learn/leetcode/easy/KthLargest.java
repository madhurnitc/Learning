package org.learn.leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

public class KthLargest {

    List<Integer> list = new LinkedList<>();
    private int k;
    public KthLargest(int k, int[] nums) {
        list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        this.k = k;
    }

    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        return list.get(list.size()-this.k-1);

    }

    private int select(List<Integer> nums) {

        int lo = 0; int hi = nums.size()-1;

        while(lo<=hi) {
            int j = partition(nums, lo, hi);
            if( j > k){
                hi = j-1;
            }else if ( j<k) {
                lo = j+1;
            }else {
                return nums.get(j);
            }
        }

        return nums.get(this.k);
    }

    private int partition(List<Integer> nums, int lo, int hi) {
        int i = lo; int j = hi+1;

        while(true) {

            break;
        }

        return 0;
    }
}

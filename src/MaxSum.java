import java.util.HashMap;
import java.util.Map;

public class MaxSum {

    public Long maxSum(int[] nums, Integer k) {

        Map<Integer, Integer> freq = new HashMap<>();
        int start = 0;
        long windowSum = 0;
        long maxWindowSum = Long.MIN_VALUE;

        for(int end =0;end<nums.length;end++) {
            windowSum += nums[end];
            freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);
            if(end-start+1 == k) {
                if(freq.size() == k) {
                   maxWindowSum = Math.max(maxWindowSum, windowSum);
                }
                freq.put(nums[start], freq.get(nums[start]) - 1);
                if(freq.get(nums[start]) == 0) {
                    freq.remove(nums[start]);
                }
                windowSum -= nums[start];
                start++;
            }
        }
        
        // Your code goes here
        return maxWindowSum == Long.MIN_VALUE ? 0L : maxWindowSum;
    }
}

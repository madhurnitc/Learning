import java.util.HashMap;
import java.util.Map;

public class MaximumSubarrayWithDistinctinKWindow {
    public long maximumSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int start =0;
        int currSum =0;
        int maxSum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int end  =0; end<nums.length; end++) {

            currSum += nums[end];
            freq.put(nums[end], freq.getOrDefault(nums[end], 1));
            if(end -start +1 == k) {

                if(freq.size() ==k ){
                    maxSum = Math.max(maxSum, currSum);
                }
                currSum-= nums[start];
                freq.put(nums[start], freq.get(nums[start])-1);
                if(freq.get(nums[start]) == 0){
                    freq.remove(nums[start]);
                }
                
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,5,4,2,9,9,9};
        int k =3;
        MaximumSubarrayWithDistinctinKWindow obj = new MaximumSubarrayWithDistinctinKWindow();
        obj.maximumSubarraySum(nums, k);
    }
}

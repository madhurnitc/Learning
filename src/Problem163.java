import java.util.ArrayList;
import java.util.List;

public class Problem163 {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {

             result.add(getFormattedRanges(lower, upper));
             return result;
        }

        if (lower != nums[0]) {
            result.add(getFormattedRanges(lower, nums[0]-1));
        }

        int prev = nums[0];

        for (int i =1 ; i < nums.length ; i++ ) {

            if(nums[i]-prev >1) {
                result.add(getFormattedRanges(prev+1, nums[i]-1));
            }

            prev = nums[i];
        }

        if(prev < upper) {

            result.add(getFormattedRanges(prev+1, upper-1));
        }

        return result;
    }

    private String getFormattedRanges(int lower, int upper) {

        return (lower != upper) ? lower + "->" + upper : Integer.toString(lower);
    }
}

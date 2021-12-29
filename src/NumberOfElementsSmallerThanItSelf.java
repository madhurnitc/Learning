import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfElementsSmallerThanItSelf {

    private int[] nums ;
    List<Integer> sorted;
    public List<Integer> countSmaller(int[] nums) {
        sorted = new ArrayList<Integer>();
        Integer[] smaller = new Integer[nums.length];
        for (int i = nums.length-1;i>=0;i--) {

            int index = getIndex(nums[i]);
            smaller[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(smaller);
    }

    private int getIndex(int item) {

        if (sorted.size() == 0) return 0;
        int start = 0;
        int end = sorted.size() - 1;
        if (sorted.get(end) < item) return end + 1;
        else if (sorted.get(start) >= item) return 0;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (sorted.get(mid) < item) start = mid + 1;
            else end = mid;
        }

        return end;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};

        new NumberOfElementsSmallerThanItSelf().countSmaller(nums);
    }
    }

import java.util.HashSet;
import java.util.Set;

public class Problem349 {

    public int[] intersection(int[] nums1, int[] nums2) {


        Set<Integer> set = new HashSet<>();
        for (int i = 0; i<nums1.length; i++) {

            set.add(nums1[i]);
        }

        for(int i =0; i< nums2.length ; i++) {

            if(set.add(nums2[i])) {
                set.remove(nums2[i]);

            }
        }
        int[] result = new int[set.size()];


        return result;
    }
}

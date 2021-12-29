public class Problem8 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {


        int i = m-1;
        int j = n-1;

        int k = nums1.length-1;

        for (int p = k ; p>= 0; p--) {

            if(i >=0 && nums1[i] > nums2[j]) {
                nums1[p] = nums1[i--];
            }else {
                nums1[p] = nums2[j--];
            }
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        new Problem8().merge(nums1,3, nums2, 3);
    }
}

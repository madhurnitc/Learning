public class Problem360SortedTransformedArray {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] sorted = new int[n];
        int left = 0, right = n-1;
        int index = a>=0 ? n-1: 0;

        while(left <= right) {

            int Yleft = calculate(nums[left],a,b,c);
            int Yright = calculate(nums[right],a,b,c);
            if(a>=0) {

                if(Yleft>=Yright) {
                    sorted[index--] = Yleft;
                    left++;
                }else {
                    sorted[index--] = Yright;
                    right--;
                }
            }else {


                if(Yleft>=Yright) {
                    sorted[index++] = Yright;
                    right--;
                }else {
                    sorted[index++] = Yleft;
                    left++;
                }

            }
        }
        return sorted;
    }

    private int calculate(int x, int a, int b, int c){


        return a*x*x + c*x + c;

    }

    public static void main(String[] args) {
        int[] nums = {-4,-2,2,4};

        int[] sorted = new Problem360SortedTransformedArray().sortTransformedArray(nums,1,3,5);

        System.out.println("####");
    }
}

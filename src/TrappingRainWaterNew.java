public class TrappingRainWaterNew {

    public Integer trappingWater(int[] height) {
        // Your code goes here

        int left =0;
        int right = height.length -1;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MAX_VALUE;
        int sum = 0;
        while(left<=right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax < rightMax) {
                sum += leftMax - height[left];
                left++;
            } else {
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }
}

package org.learn.leetcode.array;

public class TrappingRainWater {

    public int trap(int[] height) {
        int result = 0;
        if(height == null || height.length <=2 ) {
            return result;
        }
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        for(int i = 1; i<height.length ;i++) {
            left[i] = Math.max(height[i], left[i-1]);
        }

        right[height.length-1] = height[height.length-1];
        for(int i = height.length-2 ; i>=0; i--) {
            right[i] = Math.max(height[i], right[i+1]);
        }

        for(int i = 1; i< height.length-1; i++) {
            result = result + Math.min(right[i], left[i])-height[i];
        }

        return result;
    }
}

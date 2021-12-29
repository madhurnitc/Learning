import java.util.Stack;

public class LargestRectangleHistogram {


    public int largestRectangleArea(int[] heights) {

        int maxArea = Integer.MIN_VALUE;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> stackOfIndexes = new Stack<>();

        for(int i =0; i< heights.length; i++) {

           while(!stackOfIndexes.isEmpty() && heights[stackOfIndexes.peek()] > heights[i]) {

               stackOfIndexes.pop();

           }
           left[i] = stackOfIndexes.isEmpty()? 0: stackOfIndexes.peek()+1;
           stackOfIndexes.push(i);
        }

        stackOfIndexes.clear();
        for(int i = heights.length-1 ; i>=0; i--) {


            while(!stackOfIndexes.isEmpty() && heights[stackOfIndexes.peek()] > heights[i]) {
                stackOfIndexes.pop();
            }

            right[i] = stackOfIndexes.isEmpty()? heights.length-1: stackOfIndexes.peek()-1;
            stackOfIndexes.push(i);
        }

        for(int i =0; i<heights.length; i++) {

            int currentArea = (right[i]-left[i]+1)*heights[i];
            if(currentArea > maxArea) {
                maxArea = currentArea;
            }
        }

        return maxArea;

    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleHistogram().largestRectangleArea(new int[]{1,1}));
    }
}

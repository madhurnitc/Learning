import java.util.Arrays;

public class Problem1465 {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxHeight = Math.max(horizontalCuts[0], h-horizontalCuts[horizontalCuts.length-1]);
        int maxWidth = Math.max(verticalCuts[0], w-verticalCuts[verticalCuts.length-1]);

        for(int i = 1; i < horizontalCuts.length; i++){
            maxHeight = Math.max(maxWidth, horizontalCuts[i]- horizontalCuts[i-1]);
        }

        for(int i = 1; i < verticalCuts.length; i++){
            maxWidth = Math.max(maxWidth, verticalCuts[i]- verticalCuts[i-1]);
        }

        return maxWidth*maxHeight;

    }

    public static void main(String[] args) {
        new Problem1465().maxArea(5, 4, new int[]{1,3}, new int[] {1});
    }
}

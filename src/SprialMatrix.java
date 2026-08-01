import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SprialMatrix {
    public List<Integer> spiral_order(int[][] matrix) {
        // Your code goes here
        if(matrix.length == 1) {
            return new ArrayList<>();
        }

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int direction = 0;
        List<Integer> result = new ArrayList<>();
        while(left <= right && top <= bottom) {
            if(direction == 0) {
                for(int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;

            }else if(direction == 1) {
                for(int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            }else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }else if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            direction = (direction+1)%4;
        }
        return result;
    }
}

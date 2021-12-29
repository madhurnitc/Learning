import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {

    private int[] nums;
    public ShuffleArray(int[] nums) {
        this.nums = nums;
    }
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {

        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {

        int[] shuffledArray = nums.clone();
        for(int i =0 ; i< shuffledArray.length; i++) {

            int r = new Random().nextInt(i+1);
            exchange(shuffledArray, i, r);
        }

        return shuffledArray;
    }

    private void exchange(int[] shuffledArray, int i, int r) {

        int temp = shuffledArray[i];
        shuffledArray[i] = shuffledArray[r];
        shuffledArray[r] = temp;
    }
}

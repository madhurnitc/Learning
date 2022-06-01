public class MovingAverageUsingCircularArray {

    int[] array ;
    int head;
    int runningSum = 0;
    int count = 0;
    public MovingAverageUsingCircularArray(int size) {

        head = 0;
        array = new int[size];

    }

    public double next(int val) {

        if(count < array.length) count++;
        runningSum = runningSum - array[head];
        runningSum+=val;
        array[head] = val;
        head = (head+1)%array.length;

        return (double) runningSum/count;

    }
}

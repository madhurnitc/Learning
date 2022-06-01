import java.util.ArrayDeque;
import java.util.Deque;

class MovingAverage {

    private int size ;
    private Deque<Integer> dq;
    int runningSum = 0;
    public MovingAverage(int size) {

        this.size = size;
        this.dq = new ArrayDeque<>();
    }

    public double next(int val) {
        runningSum += val;
        dq.offerLast(val);
        if(dq.size()> this.size) {
            runningSum-= dq.pollFirst();
        }

        return runningSum/(double)Math.min(dq.size(), this.size);


    }

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(3);
        System.out.println(ma.next(1));
        System.out.println(ma.next(10));
        System.out.println(ma.next(3));
        System.out.println(ma.next(5));
    }
}
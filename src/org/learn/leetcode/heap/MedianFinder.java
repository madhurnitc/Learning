package org.learn.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> minHeap, maxHeap;
    public MedianFinder() {

        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

    }

    public void addNum(int num) {

        maxHeap.offer(num);
        int maxHeapTop = maxHeap.poll();
        minHeap.offer(maxHeapTop);
        if(maxHeap.size() <minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

    }

    public double findMedian() {

        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek()+minHeap.peek())/2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {

        MedianFinder mf = new MedianFinder();
        int[] arr = {41,35,62,597,108};
        for(int num : arr) {
            mf.addNum(num);
        }
    }
}

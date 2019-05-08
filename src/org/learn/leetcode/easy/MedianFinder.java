package org.learn.leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer>maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

    }

    public void addNum(int num) {

        if(minHeap.size() ==0 && maxHeap.size() ==0) {
            minHeap.offer(num);
        }else if(minHeap.size() > maxHeap.size()) {

            if(num > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }else {
                maxHeap.offer(num);
            }
        }else if (maxHeap.size() > minHeap.size()) {
            if(num < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        }else {
            minHeap.offer(num);
        }

    }

    public double findMedian() {

        if(minHeap.size() ==0 && minHeap.size() == 0) {
            return 0.0;
        } else if(minHeap.size() > maxHeap.size()) {
            return (double) minHeap.poll();
        } else if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.poll();
        }else {
            return ((double)(minHeap.poll() + maxHeap.poll()))/2.0;
        }

    }
}

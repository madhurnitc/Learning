package org.learn.org.learn.random;

public class QueueUsingArray {
    int capacity;
    int head = -1;
    int tail = -1;
    int items[];
    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
    }

    public void enqueue(int value) throws IllegalStateException {

        if(isFull()) throw new IllegalStateException();

        items[++tail] = value;
        tail = tail%capacity;
    }

    public boolean isFull() {
        return (tail+1)%capacity == head;
    }

    public boolean isEmpty() {
        return head==tail;
    }

    public int dequeue() {
        if(isEmpty()) throw new IllegalStateException();
        int val = items[head];
        items[head] = -1;
        head = (head-1)%capacity;
        return val;
    }

    public static void main(String [] args) {
        QueueUsingArray queue = new QueueUsingArray(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
    }
}

package cz.cvut.fel.pjv.impl;

import cz.cvut.fel.pjv.Queue;

import java.util.Arrays;
import java.util.Collection;

/**
 * Implementation of the {@link Queue} backed by fixed size array.
 */
public class CircularArrayQueue implements Queue {


    private int queueSize = 0;
    private final int queueCapacity;
    private String[] circularQueue;
    private int enqueueIndex = 0;
    private int dequeueIndex = 0;

    /**
     * Creates the queue with capacity set to the value of 5.
     */
    public CircularArrayQueue() {
        this(5);
    }

    /**
     * Creates the queue with given {@code capacity}. The capacity represents maximal number of elements that the
     * queue is able to store.
     * @param capacity of the queue
     */
    public CircularArrayQueue(int capacity) {
        circularQueue = new String[capacity];
        queueCapacity = capacity;
    }

    @Override
    public int size() {
        return queueSize;
    }

    @Override
    public boolean isEmpty() {
        return queueSize == 0;
    }

    @Override
    public boolean isFull() {
        return queueSize == queueCapacity;
    }

    @Override
    public boolean enqueue(String obj) {
        if (queueSize < queueCapacity && obj != null) {
            circularQueue[enqueueIndex] = obj;
            enqueueIndex = (enqueueIndex + 1) % queueCapacity;
            queueSize++;
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String dequeue() {
        if (queueSize == 0) {
            return null;
        } else {
            String ret_value = circularQueue[dequeueIndex];
            circularQueue[dequeueIndex] = null;
            dequeueIndex = (dequeueIndex + 1) % queueCapacity;
            queueSize--;
            return ret_value;
        }
    }

    @Override
    public Collection<String> getElements() {
        int search_index = dequeueIndex;
        String[] tempArray = new String[queueSize];
        for (int i = 0; i < queueSize; ++i) {
            tempArray[i] = circularQueue[search_index++ % queueCapacity];
        }
        return Arrays.asList(tempArray);
    }

    @Override
    public void printAllElements() {
        int search_index = dequeueIndex;
        for (int i = 0; i < queueSize; ++i) {
            System.out.println(circularQueue[search_index++ % queueCapacity]);
        }
    }
}

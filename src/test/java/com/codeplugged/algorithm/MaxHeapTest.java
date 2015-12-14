package com.codeplugged.algorithm;

import org.junit.Test;

/**
 * Created by abinav on 15/12/15.
 */
public class MaxHeapTest {

    @Test
    public void insertTest() {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(Integer.class, 20);
        for(int i = 1; i < 15; i++) {
            maxHeap.insert(i);
        }
        System.out.println(maxHeap.getSize());
        int size = maxHeap.getSize();
        for(int i = 0; i < size; i++) {
            System.out.println(maxHeap.extractMax());
        }

    }

}

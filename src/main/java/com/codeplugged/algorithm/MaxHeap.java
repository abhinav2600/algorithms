package com.codeplugged.algorithm;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by abinav on 15/12/15.
 */
public class MaxHeap<T extends Comparable> implements Heap<T> {
    private int heapSize = 0;
    private T[] array;
    private Class<T> classType;
    public MaxHeap(Class<T> type, int initialCapacity) {
        classType = type;
        array = (T[]) Array.newInstance(type, initialCapacity);
    }

    public void insert(T item) {
        heapSize++;
        array[heapSize - 1] = item;
        increaseKey(heapSize - 1, item);
    }

    private void increaseKey(int index, T item) {

        int parentIndex = parent(index);
        if(parentIndex >= 0) {
            while(index > 0 && array[index].compareTo(array[parentIndex]) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            }
        }

    }

    public T extractMax() {
        T max = array[0];
        swap(0, heapSize - 1);
        heapSize = heapSize - 1;
        heapify(0);
        return max;
    }

    private void heapify(int index) {
        int l = left(index);
        int r = right(index);
        int maxIndex;
        if(l < heapSize && array[l].compareTo(array[index]) > 0) {
            maxIndex = l;
        } else {
            maxIndex = index;
        }
        if(r < heapSize && array[r].compareTo(array[maxIndex]) > 0) {
            maxIndex = r;
        }
        if(maxIndex != index) {
            swap(index, maxIndex);
            heapify(maxIndex);
        }
    }

    public  T[] buildMaxHeap(T[] inputArray){
        array = inputArray;
        heapSize = inputArray.length;
        for(int i = inputArray.length/2 - 1; i >= 0; i--) {
            heapify(i);
        }
        return inputArray;
    }

    private int left(int index) {
        return 2*index + 1;
    }

    private int right(int index) {
        return 2*index + 2;
    }


    private void swap(int i1, int i2) {
        T temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    private int parent(int index) {
        return 0;
    }

    public int getSize() {
        return heapSize;
    }


}

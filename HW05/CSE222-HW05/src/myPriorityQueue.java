/*
 * Gokhan Has - 161044067
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * This is the myPriorityClass to keep Image pixel as an heap used array.
 */
public class myPriorityQueue {
    /**
     * Keeps the array capacity.Firsty initialize 20.
     */
    private int capacity = 20;
    /**
     * Keeps the array size.
     */
    private int size = 0;

    /**
     * The binary heap implementation as an array.
     */
    private myColor[] heapArr = new myColor[capacity];

    /**
     * This is the comparator object.
     */
    private Comparator<myColor> comparator;


    // Constructors ...
    public myPriorityQueue(Comparator<myColor> comp){
        comparator = comp;
    }

    /**
     * It is the queue poll method. Remove the root element in a heap(Array's first element.)
     * @return null if the priority queue is empty, otherwise return first element.
     */
    public Object poll() {
        if(size == 0)
            return null;

        myColor temp = heapArr[0];
        heapArr[0] = heapArr[size - 1];
        size--;
        goDown();
        return temp;
    }

    /**
     * It is the remove method. Remove the root element in a heap(Array's first element.)
     * @return first element.If the priorityQueue is empty, @throw NoSuchElementException.
     */
    public myColor remove() {
        if(size == 0)
            throw new NoSuchElementException();

        myColor temp = new myColor(heapArr[0]);
        heapArr[0] = heapArr[size - 1];
        size--;
        goDown();
        return temp;
    }

    /**
     * It is the queue peek method.
     * @return null if the priority queue is empty, otherwise return first element.
     */
    public Object peek() {
        if(size == 0)
            return null;
        return heapArr[0];
    }

    /**
     *
     * @return first element.If the priorityQueue is empty @throw NoSuchElementException.
     */
    public myColor element() {
        if(size == 0)
            throw new NoSuchElementException();
        return heapArr[0];
    }

    /**
     *
     * @param addedElement is myColor referances.
     * @return true if the element added in priorityQueue.
     */
    public boolean offer(myColor addedElement) {
        if(size + 1 == capacity)
            increaseCapacity();
        heapArr[size] = addedElement;
        size++;
        goUp();
        return true;
    }

    private void goUp() {
        int i = size - 1;
        while( ((i-1)/2 >= 0) && (comparator.compare(heapArr[(i-1)/2],heapArr[i])) == -1) {
            swap(((i-1)/2),i);
            i = (i-1)/2;
        }
    }

    private void goDown() {
        int i = 0;
        while((2*i + 1 < size)) {

            int tempIndex = 2*i + 1;
            if(2*i+2 < size && (comparator.compare(heapArr[2*i + 2],heapArr[2*i + 1])) == 1 )
                tempIndex = 2*i + 2;
            if(comparator.compare(heapArr[i],heapArr[tempIndex]) == 1)
                break;
            else {
                swap(i, tempIndex);
            }
            i = tempIndex;
        }
    }

    /**
     *
     * @return true if the priorityQueue is empty, otherwise false.
     */
    public boolean isEmpty() {
        if(size == 0)
            return true;
        return false;
    }

    @Override
    public String toString() {
        String returnStr = "";

        for(int i = 0; i < size; ++i)
            returnStr += heapArr[i] + "\n";
        return returnStr;
    }


    /**
     * It will be increased the array capacity.
     */
    private void increaseCapacity() {
        capacity *= 2;
        heapArr = Arrays.copyOf(heapArr,capacity);
    }

    /**
     * Swap the array elements according to parameter indexs.
     * @param first is first index.
     * @param second is second index.
     */
    private void swap(int first,int second) {
        myColor temp = heapArr[first];
        heapArr[first] = heapArr[second];
        heapArr[second] = temp;
    }
}

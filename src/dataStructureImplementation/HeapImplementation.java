package dataStructureImplementation;

import java.util.Arrays;

public class HeapImplementation {
    public static void main(String[] args) {
        HeapImplementation heapImp = new HeapImplementation();
    }

    /*
    Min heap:
    full = 10;
    size = 0;
    if(size == full)
    int[] elements = new int[10];
    a) checkSpace:
    if(size == full)
    elements = Arrays.copyOf(elements, full)
    full = full*2;
    b) heapifyUp() :
    int ind = size-1;
    int parent = ind/2;
    while (elements[parent] > elements[ind] && elements[parent] >= 0) {
    swap(elments[parent], elements[ind])
    ind = parent;
    }
      i = 0;
    c) heapifyDown() :
    int a = elements[i];
    int leftC = (2*i) +1
    int rC = (2*i) +2
    while(a > elements[leftC] || a > elements[rC] && a<=size) {
    {
    if(elements[leftC] < elements[rC] {
    swap(element[i], element[leftC])
    i = leftC;
    }
    else {
    swap(element[i], element[rC])
    i = rC;
    }
    }
    d)swap(int a, int b) {
    int temp = b;
    b = a;
    a = temp;
    }
    1)INS(int e) :
    checkSpace();
    elements[size] = e;
    size++;
    heapifyUp();
    2)Del:
    if(size == 0) {
    emptyException();
    }
    int e = elements[0];
    elements[0] = elements[size-1];
    heapifyDown();
    return e;
    3)Access:
    if(size == 0) {
    emptyException();
    }
    return elements[0];
     */
    //Min heap implementation.

    int size = 0;
    int capacity = 10;
    int[] elements = new int[capacity];
    public void ensureCapacity() {
        if(size == capacity) {
            elements = Arrays.copyOf(elements, capacity);
            capacity = capacity*2;
        }
    }

    //Same max heap - change to >
    public void heapifyUp(int elem) {
        while(elem < elements[size/2] && elements[size/2] >=0) {
            swap(elem, elements[size/2]);
            elem = elements[size/2];
        }
    }
    //Same maz heap change to < for while loop and if condition >
    public void heapifyDown() {
        int i = 0;
        int left = (2*i) +1;
        int right = (2*i) +2;
        while(elements[i] > elements[left] || elements[i] > elements[right]) {
            if(elements[left] < elements[right]) {
                swap(elements[left], elements[i]);
                i = left;
            }
            else {
                swap(elements[right], elements[i]);
                i = right;
            }
        }
    }

    public void swap(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
    }
    // Time - O(log n)
    public void insertHeap(int element) {
        ensureCapacity();
        elements[size] = element;
        size++;
        heapifyUp(element);
    }
    //Time - O(log n)
    public int deleteHeap() {
        if(size == 0) {
            throw new NullPointerException();
        }
        int deleteElem = elements[0];
        deleteElem = elements[size-1];
        heapifyDown();
        return deleteElem;
    }
    //Time - O(1)
    public int accessHeap() {
        if (size == 0) {
            throw new NullPointerException();
        }
        return elements[0];
    }
}

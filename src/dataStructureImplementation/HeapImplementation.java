package dataStructureImplementation;

import javax.sound.sampled.Control;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import java.awt.geom.Line2D;
import java.util.Arrays;

public class HeapImplementation {
    public static void main(String[] args) {
        HeapImplementation heapImp = new HeapImplementation();
        int arr[] = {15, 17, 20, 1, 5, 10, 30};
        heapImp.heapSort(arr);
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
    /*
    1) Heapify :
    n = arr.size
    i = n/2; i>=0; i--
        heapify(arr[], n, i) :
        parent = i
        l = 2*i +1
        r = 2*i +2
        a[l] > a[p] && l<=n
            p = l;
        a[r] > a[p] && r<=n
            p = r;
        if(l !=i)
            swap(a[i], a[p])
        heapify(arr[], n, p)
     2) Deleting priority(root) element:
     int sort = a[0]
     a[0] = a[n-1]
     a[n-1] = sort
     i = n-1; i >=0; i--
     swap(a[0], a[n-1])
     heapify(a[], i-1, 0)
     */
    //Heap sort implementation. Max heap used here for sorting in ascending order. Time - O(n logn)
    //Step1 : Running across the height of tree(Creation) - log n time * heapify is called for all n elements => O(n logn)
    //Step 2: Deletion of elements - log n time * running across each n elements => O(n logn)
    // n logn + nlogn = 2 n logn => O(n logn)
    public void heapSort(int[] arr) {
        int n = arr.length;
        for(int i = (n/2)-1; i>=0 ; i--) {
            maxHeapify(arr, n, i);
        }
        sortHeapify(arr, n);
    }
    //Heapify - Time - O(n)
    public void maxHeapify(int[] arr, int n, int i) {
        int parent = i;
        int leftChild = (2*i)+1;
        int rightChild = (2*i)+2;

        if(arr[leftChild] > arr[parent] && leftChild <= n-1) {
            parent = leftChild;
        }
        if(arr[rightChild] > arr[parent] && rightChild <= n-1) {
            parent = rightChild;
        }
        if(parent != i) {
            swap(arr[i], arr[parent]);
            maxHeapify(arr, n, parent);
        }
    }

    //Sort - O(log n)
    public void sortHeapify(int arr[], int n) {
        for(int i = n-1; i>0; i--) {
            swap(arr[0], arr[i]);
            maxHeapify(arr, i-1,0);
        }
    }
}

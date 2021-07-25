package dataStructureImplementation;

import java.util.EmptyStackException;

public class QueueDataStructure<size> {
    public static void main(String[] args) {
        QueueDataStructure queueds = new QueueDataStructure();
        queueds.enqueueArray(5);
        queueds.enqueueArray(3);
        queueds.enqueueArray(15);
        queueds.enqueueArray(13);
        queueds.enqueueArray(55);
    }
    int size = 4;
    int enqueueArr[] = new int[size];
    int front =-1, rear = -1;

    //Time - O(1)
    public void enqueueArray(int value) {
        if(rear == size-1) {
            throw new EmptyStackException();
        }
        else if(front == -1 && rear == -1) {
            front = rear = 0;
            enqueueArr[rear] = value;
        }
        else {
            rear++;
            enqueueArr[rear] = value;
        }

    }
}

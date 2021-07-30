package dataStructureImplementation;

import java.util.EmptyStackException;

public class QueueDataStructure<size> {
    public static void main(String[] args) {
        /*QueueDataStructure queueds = new QueueDataStructure();
        queueds.enqueueArray(5);
        queueds.enqueueArray(3);
        queueds.enqueueArray(15);
        queueds.enqueueArray(13);
        queueds.dequeueArray();
        queueds.dequeueArray();
        queueds.displayQueue();
        queueds.peekQueue(); */

        queueLL qLL = new queueLL();
        qLL.enqueueLL(1);
        qLL.enqueueLL(2);
        qLL.enqueueLL(3);
        qLL.displayQueueLL();
        qLL.peekLL();
        qLL.dequeueLL();

    }

    int size = 4;
    int enqueueArr[] = new int[size];
    int front = -1, rear = -1;

    //Time - O(1)
    public void enqueueArray(int value) {
        if (rear == size - 1) {
            throw new EmptyStackException();
        } else if (front == -1 && rear == -1) {
            front = rear = 0;
            enqueueArr[rear] = value;
        } else {
            rear++;
            enqueueArr[rear] = value;
        }
    }

    //Time - O(1)
    public int dequeueArray() {
        int dequeuedElement = -1;
        if (front == -1 && rear == -1) {
            throw new EmptyStackException();
        } else if (front == rear) {
            front = rear = -1;
        } else {
            dequeuedElement = enqueueArr[front];
            front++;
        }
        return dequeuedElement;
    }

    //Display - O(n)
    public void displayQueue() {
        if (front == -1 && rear == -1) {
            throw new EmptyStackException();
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.println(enqueueArr[i]);
            }
        }
    }

    //Peek - O(1)
    public int peekQueue() {
        if (front == -1 && rear == -1) {
            throw new EmptyStackException();
        }
        return enqueueArr[front];
    }

}
    //Queue using Linked list
/*  r
    1-2-3
      f  r
*/
    class queueLL {
        class Node {
            Node next;
            int data;

            public Node(int data) {
                this.data = data;
            }
        }
        Node front = null, rear = null;
        //Time - O(1)
        public void enqueueLL(int  number) {
            Node newNode = new Node(number);
            if(front == null && rear == null) {
                front = rear = newNode;
            }
            else {
                rear.next = newNode;
                rear = rear.next;
            }
        }
        //Time - O(n)
        public void displayQueueLL() {
            Node temp = front;
            while(temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
        //Time - O(1)
        public int dequeueLL() {
            if(front == null) {
                throw new NullPointerException();
            }
            else if(front == rear) {
                front = null;
                rear = null;
            }
            front = front.next;
            return front.data;
        }
        //Time - O(1)
        public int peekLL() {
            if(front == null) {
                System.out.println("Queue is empty or throw exception");
            }
            return front.data;
        }

    }


package dataStructureImplementation;

import java.util.Arrays;

public class StackDataStructure {
    public static void main(String[] args) {
        /*StackDataStructure stackds = new StackDataStructure();

        stackds.pushStack(1);
        stackds.pushStack(2);
        stackds.pushStack(3);
        //stackds.popStack();
        //stackds.peekStack();
        //stackds.isFullStack();
        //stackds.isEmptyStack();
        System.out.println(Arrays.toString(stackds.displayStack()));*/

        StackLL stackll = new StackLL();
        stackll.pushStackLL(1);
        stackll.pushStackLL(2);
        stackll.pushStackLL(3);
        stackll.displayStackLL();
    }

    int top = -1;
    int arraySize = 5;
    int[] stackElement = new int[arraySize];
    public void pushStack(int element) {
        top++;
        if (top >= arraySize-1) {
            isFullStack();
            System.out.println("Overflow Condition");
        }
        stackElement[top] = element;
    }
    public int popStack() {
        int item = stackElement[top];
        top--;
        if(top == -1) {
            isEmptyStack();
            System.out.println("Underflow confition");
        }
        return item;
    }

    public int peekStack() {
        if(top == -1) {
            isEmptyStack();
        }
        int topValue = stackElement[top];
        System.out.println(topValue);
        return topValue;
    }
    public boolean isEmptyStack() {
        return (top == -1);
    }
    public boolean isFullStack() {
        return (top == arraySize-1);
    }
    public int[] displayStack() {
        int[] element = new int[arraySize];
        for(int i = top; i >= 0; i--) {
            element[i] = stackElement[i];
        }
        return element;
    }
}

class StackLL {
    class Node {
        int data;
        Node next;

        public Node(int dataValue) {
            data = dataValue;
        }
    }

    Node topStackLL = null;
    public void pushStackLL(int dataElement) {
        Node newNode = new Node(dataElement);
        newNode.next = topStackLL;
        topStackLL = newNode;
    }

    public void displayStackLL() {
        Node temp = topStackLL;
        if(temp == null) {
            System.out.println("Stack is empty or underflow condition");
        }
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

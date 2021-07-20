package dataStructureImplementation;

import java.util.Arrays;

public class StackDataStructure {
    public static void main(String[] args) {
        StackDataStructure stackds = new StackDataStructure();

        stackds.pushStack(1);
        stackds.pushStack(2);
        stackds.pushStack(3);
        //stackds.popStack();
        //stackds.peekStack();
        //stackds.isFullStack();
        //stackds.isEmptyStack();
        System.out.println(Arrays.toString(stackds.displayStack()));
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

package dataStructureImplementation;

import java.util.Scanner;

public class StackDataStructure {
    public static void main(String[] args) {
        StackDataStructure stackds = new StackDataStructure();

        stackds.pushStack(1);
        stackds.pushStack(2);
    }

    int top = -1;
    int arraySize = 5;
    int[] push = new int[arraySize];
    public void pushStack(int element) {
        top++;
        if (top >= arraySize-1) {
            System.out.println("Overflow Condition");
        }
        push[top] = element;
    }
}

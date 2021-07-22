package dataStructureImplementation;

import java.util.EmptyStackException;

public class StackDSProblems {
    public static void main(String[] args) {
        StackDSProblems stack = new StackDSProblems();
        ThreeStacksUsingSingleArrayFixedDivision stackArray = new ThreeStacksUsingSingleArrayFixedDivision(2);
        stackArray.push(0,7);
        stackArray.push(0,8);
        stackArray.pop(0);
        stackArray.peek(0);
        stackArray.pop(1);
    }
}
    //1)Use Single array to implement three stacks
    //Approach 1 : Fixed Division of arrays( Stacks elements size is known use this)

class ThreeStacksUsingSingleArrayFixedDivision {
        public int StackNumbers = 3;
        public int size[];
        public int arrayValues[];
        public int arrayCapacity;


    public ThreeStacksUsingSingleArrayFixedDivision(int capacity) {
        arrayCapacity = capacity;
        size = new int[StackNumbers];
        arrayValues = new int[arrayCapacity * StackNumbers];
        }

    public void push(int stackNum, int element) {
        if(isStackFull(stackNum)) {
            throw new StackOverflowError();
        }
        size[stackNum]++;
        arrayValues[topindex(stackNum)] = element;
    }

    public int pop(int stackNum) {
        if(isStackEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int popedElement = arrayValues[topindex(stackNum)];
        arrayValues[topindex(stackNum)] = -1;
        size[stackNum]--;
        return popedElement;
    }

    public int peek(int stackNum) {
        if(isStackEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        System.out.println("Peek" + arrayValues[topindex(stackNum)]);
        return arrayValues[topindex(stackNum)];
    }
    public boolean isStackEmpty(int stackNum) {
        return size[stackNum] == 0;
    }
    public boolean isStackFull(int stackNum) {
        return (size[stackNum] == arrayCapacity);
    }

    public int topindex(int stacknum) {
        int offset = stacknum * arrayCapacity;
        int sizeValue = size[stacknum];
        return offset + sizeValue - 1;
    }
    }

package dataStructureImplementation;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackDSProblems {
    public static void main(String[] args) {
        /*StackDSProblems stack = new StackDSProblems();
        ThreeStacksUsingSingleArrayFixedDivision stackArray = new ThreeStacksUsingSingleArrayFixedDivision(2);
        stackArray.push(0,7);
        stackArray.push(0,8);
        stackArray.pop(0);
        stackArray.peek(0);
        stackArray.pop(1);

        StackMin stackmin = new StackMin();
        stackmin.push(3);
        stackmin.push(5);
        stackmin.push(1);
        stackmin.pop();
        stackmin.pop();
        stackmin.pop();
        stackmin.pop();*/

        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(13);
        minStack.push(6);
        minStack.push(23);
        minStack.pop();
        minStack.pop();
        minStack.pop();

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
        if (isStackFull(stackNum)) {
            throw new StackOverflowError();
        }
        size[stackNum]++;
        arrayValues[topindex(stackNum)] = element;
    }

    public int pop(int stackNum) {
        if (isStackEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int popedElement = arrayValues[topindex(stackNum)];
        arrayValues[topindex(stackNum)] = -1;
        size[stackNum]--;
        return popedElement;
    }

    public int peek(int stackNum) {
        if (isStackEmpty(stackNum)) {
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

    //2) Min Stack - In addition to push and stack design a stack to have min value to return the minimum value . Time - O(1), Space - O(n)

    class StackMin {
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push(int value) {
            if(minStack.isEmpty() || value <= getMin()) {
                minStack.push(value);
            }
            mainStack.push(value);
        }

        public int pop() {
            if(mainStack.peek() <= 0 || minStack.peek() <= 0) {
                throw new EmptyStackException();
            }
            int poppedValue = mainStack.pop();
            if(poppedValue == minStack.peek()) {
                minStack.pop();
            }
            return poppedValue;
        }

        public int getMin() {
            return minStack.peek();
        }
    }
//2) Min Stack - In addition to push and stack design a stack to have min value to return the minimum value . Time - O(1), Space - O(1)
class MinStack {
    Stack<Integer> stackmain = new Stack<>();
    int min;

    public void push(int value) {
        if(stackmain.isEmpty()) {
            stackmain.push(value);
            min = value;
        }
        else if (value > getMin()) {
            stackmain.push(value);
        }
        else {
            min = value;
            int pushValue = (2*value) - min;
            stackmain.push(pushValue);
        }
    }

    public int pop() {
        int poppedValue;
        if(stackmain.size() < 0) {
            throw new EmptyStackException();
        }
        else if (stackmain.peek() < getMin()) {
            poppedValue = stackmain.pop();
            min = (2*min) - poppedValue;
        }
        else {
            poppedValue = stackmain.pop();
        }
        return poppedValue;
    }

    public int getMin() {
        return min;
    }
}


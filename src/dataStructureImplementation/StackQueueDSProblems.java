package dataStructureImplementation;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackQueueDSProblems {
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
        stackmin.pop();

        MinStack minStack = new MinStack();
        minStack.push(8);
        minStack.push(11);
        minStack.push(6);
        minStack.push(2);
        minStack.push(5);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();*/

        QueueStack queueStack = new QueueStack();
        /*queueStack.enqueue(4);
        queueStack.enqueue(5);
        queueStack.enqueue(6);
        queueStack.deQueue();*/
        queueStack.enqueueStack(1);
        queueStack.dequeueStack();
        queueStack.dequeueStack();
        queueStack.peekStack();
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
        else if (value >= getMin()) {
            stackmain.push(value);
        }
        else {
            int pushValue = (2*value) - min;
            stackmain.push(pushValue);
            min = value;
        }
    }

    public int pop() {
        int poppedValue;
        if(stackmain.size() <= 0) {
            throw new EmptyStackException();
        }
        else if (stackmain.peek() <= getMin()) {
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
//4) Implement Queue via stack. Time - O(n), Space - O(n)
class QueueStack {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> subStack = new Stack<>();
    int count = 0;
    public void enqueue(int value) {
        mainStack.push(value);
        count++;
    }
    public void deQueue() {
        if(mainStack.isEmpty()) {
            throw new EmptyStackException();
        }
        int poppedMainStack;
        for(int i=0; i<count; i++) {
            poppedMainStack = mainStack.pop();
            subStack.push(poppedMainStack);
        }
        subStack.pop();
        count--;
        int poppedSub;
        for(int i=0; i<count; i++) {
            poppedSub = subStack.pop();
            mainStack.push(poppedSub);
        }
    }
//4) Implement Queue via stack. Time - O(1), Space - O(n)
    Stack<Integer> newStack = new Stack<>();
    Stack<Integer> oldStack = new Stack<>();

    public void enqueueStack(int element) {
        newStack.push(element);
    }

    public int dequeueStack() {
        if(newStack.isEmpty() && oldStack.isEmpty()) {
            throw new EmptyStackException();
        }
        shiftStack();
        return oldStack.pop();
    }

    public int peekStack() {
        if(oldStack.isEmpty() && newStack.isEmpty()) {
            throw new EmptyStackException();
        }
        shiftStack();
        return oldStack.peek();
    }

    public void shiftStack() {
        if(oldStack.isEmpty()) {
            while(!(newStack.isEmpty())) {
                oldStack.push(newStack.pop());
            }
        }
    }

}


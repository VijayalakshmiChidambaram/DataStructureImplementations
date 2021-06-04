package dataStructureImplementation;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDataStructure {
    public static void main(String[] args) {
        ArrayDataStructure arr = new ArrayDataStructure();
        /*System.out.println(Arrays.toString(arr.traversal()));
        System.out.println(Arrays.toString(arr.arrayinsertmiddle()));
        System.out.println(Arrays.toString(arr.arrayInsertionEnd()));
        System.out.println(Arrays.toString(arr.arrayInsertBegin()));
        System.out.println(Arrays.toString(arr.unSortedArrayInsert()));
        System.out.println(Arrays.toString(arr.sortedArrayDeletemid()));*/
        System.out.println(Arrays.toString(arr.sortArray()));
    }

    //Array Traversal
    public int[] traversal() {
        int[] arrayTraverse = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter a value : ");
            Scanner inputArray = new Scanner(System.in);
            arrayTraverse[i] = inputArray.nextInt();
        }
        return arrayTraverse;
    }

    //Insertion into Sorted Array
    //Insertion at the middle
    public int[] arrayinsertmiddle() {
        int[] arraymid = new int[10];
        arraymid[0] = 1;
        arraymid[1] = 2;
        arraymid[2] = 4;
        arraymid[3] = 5;
        arraymid[4] = 6;
        int size = arraymid.length;

        int insertionSize = 5;
        int position = 3;
        int insertionNumber = 3;
        if (position <= 0 || position > size) {
            System.out.println("Array index out of bound exception");
        }
        for (int i = insertionSize - 1; i >= position - 1; i--) {
            arraymid[i + 1] = arraymid[i];
        }
        arraymid[position - 1] = insertionNumber;
        insertionSize++;

        return arraymid;
    }

    //InsertionAtEnd
    public int[] arrayInsertionEnd() {
        int[] arrayEnd = new int[10];
        int insertionNumber = 6;
        for (int i = 0; i < insertionNumber; i++) {
            System.out.println("Enter the required sorted numbers: ");
            Scanner insertNumber = new Scanner(System.in);
            arrayEnd[i] = insertNumber.nextInt();
        }

        int insertEnd = 15;
        arrayEnd[insertionNumber] = insertEnd;
        insertionNumber++;

        return arrayEnd;
    }

    //InsertionAtBeginning
    public int[] arrayInsertBegin() {
        int[] arrayBegin = new int[5];
        int insertionSize = 3;
        int insertElement = 0;
        for (int i = 0; i < insertionSize; i++) {
            System.out.println("Enter the values ");
            Scanner insertNumbers = new Scanner(System.in);
            arrayBegin[i] = insertNumbers.nextInt();
        }
        for (int i = insertionSize - 1; i <= 0; i++) {
            arrayBegin[i + 1] = arrayBegin[i];
        }
        arrayBegin[0] = insertElement;
        insertionSize++;
        return arrayBegin;
    }

    //Insertion into UnSorted Array
    //Insertion at the middle
    public int[] unSortedArrayInsert() {
        int[] unsortedarraymid = new int[10];
        unsortedarraymid[0] = 1;
        unsortedarraymid[1] = 2;
        unsortedarraymid[2] = 3;
        unsortedarraymid[3] = 5;
        unsortedarraymid[4] = 6;
        int size = unsortedarraymid.length;
        int position = 3;
        int insertNumber = 4;
        int sizeOfArray = 5;
        if (position <= 0 || position > size) {
            System.out.println("Array index out of bound exception");
        }
        unsortedarraymid[sizeOfArray - 1] = unsortedarraymid[position - 1];
        unsortedarraymid[position - 1] = insertNumber;

        return unsortedarraymid;
    }

    //Deletion into Sorted Array
    //Deletion from middle
    public char[] sortedArrayDeletemid() {
        char[] arraydelmid = {'a', 'b', 'c', 'd', 'e'};
        int position = 2;
        int size = arraydelmid.length;
        char[] newarraydelmid = new char[size - 1];

        for (int i = position; i < size; i++) {
            arraydelmid[i - 1] = arraydelmid[i];
        }
        System.arraycopy(arraydelmid, 0, newarraydelmid, 0, size - 1);
        return newarraydelmid;
    }

    //Array Sorting
    public int[] sortArray() {
        int[] unsortedArray = {11, 2, 3, 1, 6, 3, 5, 8, 9, 19, 23};
        int size = unsortedArray.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (unsortedArray[i] >= unsortedArray[j]) {
                    int temp = unsortedArray[i];
                    unsortedArray[i] = unsortedArray[j];
                    unsortedArray[j] = temp;
                }

            }
        }
        return unsortedArray;
    }
}


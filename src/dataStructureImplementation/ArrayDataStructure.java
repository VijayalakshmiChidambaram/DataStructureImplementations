package dataStructureImplementation;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDataStructure {
    public static void main(String[] args) {
        ArrayDataStructure arr = new ArrayDataStructure();
        System.out.println(Arrays.toString(arr.traversal()));
    }

    public int[] traversal() {
        int[] arrayTraverse = new int[10];
        for (int i = 0; i<10; i++) {
            System.out.println("Enter a value : ");
            Scanner inputArray = new Scanner(System.in);
            arrayTraverse[i] = inputArray.nextInt();
        }
        return arrayTraverse;
    }


}

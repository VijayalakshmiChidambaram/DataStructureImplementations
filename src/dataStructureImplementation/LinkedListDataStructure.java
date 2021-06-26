package dataStructureImplementation;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListDataStructure {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.insert(2);
        node.insert(3);
        System.out.println(node);
    }

}
//Define own datatype
class Node {
    int data;
    Node next;
    Node temp;
    Node head;

    public Node(int dataValue) {
        data = dataValue;
    }
    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.data = this.data;

        if (head.next == null) {
            head = newNode;
            temp = newNode;
        }
        temp.next = newNode;
        temp = newNode;
    }

}

package dataStructureImplementation;

public class LinkedListDataStructure {
    public static void main(String[] args) {
        Node node = new Node(1);

        System.out.println(node);
    }

}
    //Define own datatype
    class Node {
        int data;
        Node next;

        public Node(int dataValue) {
            data = dataValue;
        }
    }
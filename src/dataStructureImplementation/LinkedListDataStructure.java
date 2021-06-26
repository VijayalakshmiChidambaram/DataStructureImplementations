package dataStructureImplementation;

public class LinkedListDataStructure {
    public static void main(String[] args) {
        singlyLinkedList node = new singlyLinkedList();
        node.createNodes(11);
        node.createNodes(2);
        node.createNodes(1);
        node.createNodes(20);
        node.printValues();
    }
}

class singlyLinkedList {
    //Define own datatype
    class Node {
        int data;
        Node next;

        public Node(int dataValue) {
            data = dataValue;
        }
    }
        Node head;
        Node temp;

        public void createNodes(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }

        public void printValues() {
            Node currentNode = head;
            System.out.println("LL");
            while (currentNode != null) {
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            }
        }
}
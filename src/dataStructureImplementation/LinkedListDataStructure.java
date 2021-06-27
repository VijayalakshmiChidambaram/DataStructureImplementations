package dataStructureImplementation;

public class LinkedListDataStructure {
    public static void main(String[] args) {
        singlyLinkedList node = new singlyLinkedList();
        node.createNodesSLL(11);
        node.createNodesSLL(2);
        node.createNodesSLL(1);
        node.createNodesSLL(20);
        node.printValues();
        node.insertNodeBeginSLL(15);
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

        public int createNodesSLL(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
            return temp.data;
        }
        //Insertion into a list of already inserted nodes
        public void insertNodeBeginSLL(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
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
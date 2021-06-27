package dataStructureImplementation;

public class LinkedListDataStructure {
    public static void main(String[] args) {
        singlyLinkedList node = new singlyLinkedList();
        node.createNodesSLL(11);
        node.createNodesSLL(22);
        node.createNodesSLL(33);
        node.createNodesSLL(40);
        node.printValues();
        node.insertNodeBeginSLL(5);
        node.printValues();
        //node.insertNodeEndSLL(45);
        //node.printValues();
        node.insertNodeMiddle(15,2);
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

        public void insertNodeEndSLL(int data) {
            Node newNode = new Node(data);
            if(head == null) {
                head = newNode;
                return;
            }
            while (temp.next!=null) {
                temp = temp.next;
                System.out.println("temp" + temp);
            }
            temp.next = newNode;
            newNode.next = null;
        }

        public void insertNodeMiddle(int data, int position) {
            Node newNode = new Node(data);
            temp = head;
            int i=0;
            while (i<position-1) {
                temp = temp.next;
                i++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
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
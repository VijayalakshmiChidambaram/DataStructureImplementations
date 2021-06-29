package dataStructureImplementation;

public class LLProblemSolving {
    public static void main(String[] args) {
        singlyLinkedListPrograms llist = new singlyLinkedListPrograms();
        llist.createNodes(1);
        llist.createNodes(10);
        llist.createNodes(20);
        llist.createNodes(30);

        llist.printNodes();
    }
}

class singlyLinkedListPrograms {
    class Nodes {
        int data;
        Nodes next;

        public Nodes(int data) {
            this.data = data;
        }
    }

    Nodes head;
    Nodes temp;
    public void createNodes(int data) {
        Nodes newNode = new Nodes(data);
        if(head == null) {
            head = temp = newNode;
        }
        else {
            temp.next = newNode;
            temp = newNode;
        }
    }

    public void printNodes() {
        Nodes currentNode;
        currentNode = head;
        while (currentNode!=null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }
}



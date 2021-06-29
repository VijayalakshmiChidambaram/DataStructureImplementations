package dataStructureImplementation;

import java.util.HashSet;
import java.util.Hashtable;

public class LLProblemSolving {
    public static void main(String[] args) {
        singlyLinkedListPrograms llist = new singlyLinkedListPrograms();
        llist.createNodes(1);
        llist.createNodes(10);
        llist.createNodes(10);
        llist.createNodes(30);
        llist.createNodes(20);
        llist.createNodes(30);

        llist.printNodes();
        llist.removeDuplicatesUsingHashset();
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
        System.out.println("LL Data: ");
        while (currentNode!=null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }
//1) Removing duplicates using extra space - Hashset, Time complexity - O(n)
    public void removeDuplicatesUsingHashset() {
     Nodes prev, curr;
     prev=head;
     curr=head;
     HashSet<Integer> set = new HashSet<>();

     while(curr != null) {
         if(set.contains(curr.data)) {
             prev.next = curr.next;
         }
         else {
             set.add(curr.data);
             prev=curr;
         }
         curr=curr.next;
     }
    }
//1) Removing duplicates using extra space - HashTable, Time complexity - O(n)
    public void removeDuplicatesHashTable() {
        Nodes curr, prev;
        curr = head;
        prev = null;
        Hashtable<Integer, Boolean> table = new Hashtable<>();

        while (curr !=null) {
            if (table.containsKey(curr.data)) {
                prev.next = curr.next;
            }
            else{
                table.put(curr.data, true);
                prev = curr;
            }
            curr = curr.next;
        }

    }
}



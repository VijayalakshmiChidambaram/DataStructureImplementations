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
        llist.createNodes(15);
        llist.createNodes(25);

        llist.printNodes();
        //llist.removeDuplicatesUsingHashset();
        //llist.removeDuplicatesHashTable();
        llist.removeDuplicatesTwoPointer();
        llist.returnKthNodeIterative( 2);
        //llist.returnKthElementRecursive(llist.head, 2);
        llist.returnKthElementRecursiveWithCounter(llist.head, 2, 0);
        //llist.printNodes();
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
    //1) Removing duplicates without extra space - HashTable, Space -O(1), Time complexity - O(n^2)
    public void removeDuplicatesTwoPointer() {
        Nodes p, n;
        p=head;
        while(p!=null) {
            n=p;
            while (n.next!=null) {
                if(p.data == n.next.data) {
                    n.next = n.next.next;
                }
                else{
                    n=n.next;
                }
            }
            p=p.next;
        }
    }
    //2) Return kth node from the end - Iterative approach
    public int returnKthNodeIterative(int position) {
        Nodes p1 = head;
        Nodes p2 = head;
        for(int i=0; i<position; i++) {
            p1 = p1.next;
        }
        while (p1!=null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2.data;
    }

   public int returnKthElementRecursive(Nodes head, int position) {
        if(head==null) {
            return 0;
        }
        int index = returnKthElementRecursive(head.next, position) + 1;
        if(index == position) {
            System.out.println(position +" to last element "+ head.data);
        }
        return index;
    }

    public int returnKthElementRecursiveWithCounter(Nodes head, int position, int i) {
        if(head==null) {
            return 0;
        }
        int index = returnKthElementRecursiveWithCounter(head.next, position, i);
        i = i+1;
        if(i  == position) {
            System.out.println(position +" to last element" + head.data);
        }
        return position;
    }
}



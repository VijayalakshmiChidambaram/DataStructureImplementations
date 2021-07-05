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
        //llist.removeDuplicatesUsingHashset();
        //llist.removeDuplicatesHashTable();
        llist.removeDuplicatesTwoPointer();
        llist.returnKthNodeIterative( 2);
        llist.returnKthElementRecursive(llist.head, 2);
        llist.printNodes();
        llist.deleteMiddleNode(llist.head.next.next);
        //llist.deleteMiddleNodeOnly(llist.head);
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
    //2) Return kth node from the end - Iterative approach Time - O(n), Space - O(1)
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
    //2) Return kth node from the end - Recursive approach, Time - O(n)
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
    //3) Delete Middle Node(Given access to only that node)
    /* 1-> 2-> 3-> 4-> 5 Delete = 3
    1-> 2-> 4-> 5
    Dummy node - Copy next node data to it.
    Move dummy node data to current node and make the next pointer of dummy node as the next pointer of current
     */

    Nodes deleteMiddleNode(Nodes middle) {
        if(middle == null || middle.next== null) {
            return null;
        }
        Nodes dummyNode;
        dummyNode = middle.next;
        middle.data = dummyNode.data;
        middle.next = dummyNode.next;
        return head;
    }

    Nodes deleteMiddleNodeOnly(Nodes middle) {
        if(middle == null || middle.next== null) {
            return null;
        }
        Nodes dummyNode = middle;
        dummyNode.data= middle.data;
        dummyNode.data = dummyNode.next.data;
        dummyNode.next = dummyNode.next.next;
        return head;
    }
}



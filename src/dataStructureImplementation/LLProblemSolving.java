package dataStructureImplementation;

import java.util.HashSet;
import java.util.Hashtable;

public class LLProblemSolving {
    public static void main(String[] args) {
        singlyLinkedListPrograms llist = new singlyLinkedListPrograms();
        llist.createNodes(1);
        llist.createNodes(2);
        //llist.createNodes(3);
        llist.createNodes(2);
        llist.createNodes(1);
        singlyLinkedListPrograms llist2 = new singlyLinkedListPrograms();
        llist2.createNodes(11);
        llist2.createNodes(2);
        llist2.createNodes(3);
        llist2.createNodes(2);
        llist2.createNodes(1);
        singlyLinkedListPrograms llist3 = new singlyLinkedListPrograms();
        llist3.createNodes(17);
        llist3.createNodes(18);
        llist3.createNodes(19);
        //llist.createNodes(5);
        /*llist.removeDuplicatesUsingHashset();
        llist.removeDuplicatesHashTable();
        llist.removeDuplicatesTwoPointer();
        llist.returnKthNodeIterative( 2);
        llist.returnKthElementRecursive(llist.head, 2);
        llist.printNodes();
        llist.deleteMiddleNode(llist.head.next.next);
        llist.deleteMiddleNodeOnly(llist.head.next.next);
        llist.recursivePalindrome(llist.head);
        llist.partitionLLCreatingTwoSeparatelists(20);
        llist.partitionUsing4pointers(10);
        llist.sumlistsReverseOrderIterative(llist.head, llist2.head);
       llist.sumlistsReverseOrderRecursive(llist.head, llist2.head, 0);
        llist.intersectionTwoPointers(llist.head, llist2.head, llist3.head);
        llist.intersectionTwoListsFindingLengthDiff(llist.head, llist2.head, llist3.head);
        llist.intersectionTwoListsUsingHashing(llist.head, llist2.head, llist3.head);
        llist.loopDetectionTwoPointers(llist.head);
        llist.circularLoopDetectionHashTable(llist.head);*/
        llist.palindromeUsingReverseLL(llist.head);
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
        if (head == null) {
            head = temp = newNode;
        } else {
            temp.next = newNode;
            temp = newNode;
        }
    }

    public void printNodes() {
        Nodes currentNode;
        currentNode = head;
        System.out.println("LL Data: ");
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    //1) Removing duplicates using extra space - Hashset, Time complexity - O(n)
    public void removeDuplicatesUsingHashset() {
        Nodes prev, curr;
        prev = head;
        curr = head;
        HashSet<Integer> set = new HashSet<>();

        while (curr != null) {
            if (set.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    //1) Removing duplicates using extra space - HashTable, Time complexity - O(n)
    public void removeDuplicatesHashTable() {
        Nodes curr, prev;
        curr = head;
        prev = null;
        Hashtable<Integer, Boolean> table = new Hashtable<>();

        while (curr != null) {
            if (table.containsKey(curr.data)) {
                prev.next = curr.next;
            } else {
                table.put(curr.data, true);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    //1) Removing duplicates without extra space - HashTable, Space -O(1), Time complexity - O(n^2)
    public void removeDuplicatesTwoPointer() {
        Nodes p, n;
        p = head;
        while (p != null) {
            n = p;
            while (n.next != null) {
                if (p.data == n.next.data) {
                    n.next = n.next.next;
                } else {
                    n = n.next;
                }
            }
            p = p.next;
        }
    }

    //2) Return kth node from the end - Iterative approach Time - O(n), Space - O(1)
    public int returnKthNodeIterative(int position) {
        Nodes p1 = head;
        Nodes p2 = head;
        for (int i = 0; i < position; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2.data;
    }

    //2) Return kth node from the end - Recursive approach, Time - O(n)
    public int returnKthElementRecursive(Nodes head, int position) {
        if (head == null) {
            return 0;
        }
        int index = returnKthElementRecursive(head.next, position) + 1;
        if (index == position) {
            System.out.println(position + " to last element " + head.data);
        }
        return index;
    }
    //3) Delete Middle Node(Given access to only that node) Time - O(n), Space- O(1)
    /* 1-> 2-> 3-> 4-> 5 Delete = 3
    1-> 2-> 4-> 5
    Dummy node - Copy next node data to it.
    Move dummy node data to current node and make the next pointer of dummy node as the next pointer of current
     */

    Nodes deleteMiddleNode(Nodes middle) {
        if (middle == null || middle.next == null) {
            return null;
        }
        Nodes dummyNode;
        dummyNode = middle.next;
        middle.data = dummyNode.data;
        middle.next = dummyNode.next;
        return head;
    }

    //3) Delete Middle Node(Given access to only that node) Time - O(n), Space- O(1)
    Nodes deleteMiddleNodeOnly(Nodes middle) {
        if (middle == null || middle.next == null) {
            return null;
        }
        Nodes dummyNode = middle;
        dummyNode.data = middle.data;
        dummyNode.data = dummyNode.next.data;
        dummyNode.next = dummyNode.next.next;
        return head;
    }

    //4) Partition Linked list- Values less than partition element before it. Order not required to maintain
    // Time Complexity- O(n), Space complexity - O(n) [Extra nodes created to store two separate lists]
    Nodes partitionLLCreatingTwoSeparatelists(int partition) {

        if (head == null || head.next == null) {
            return null;
        }
        temp = head;

        Nodes smallElements = new Nodes(0);
        Nodes smallHead = smallElements;
        Nodes largeElements = new Nodes(0);
        Nodes largeHead = largeElements;
        while (temp != null) {
            if (temp.data < partition) {
                smallHead.next = temp;
                smallHead = smallHead.next;
            } else {
                largeHead.next = temp;
                largeHead = largeHead.next;
            }
            temp = temp.next;
        }
        largeHead.next = null;
        smallHead.next = largeElements.next;
        return smallElements;
    }

    /*
        Nodes partitionUsing4pointers(int partition) {
            if(head == null || head.next == null) {
                return head;
            }
            temp = head;
            Nodes smallElements = null;
            Nodes smallHead = null;
            Nodes largeElements = null;
            Nodes largeHead = null;
            while (temp != null) {
                if(temp.data < partition) {
                if (smallElements == null) {
                    smallElements = temp;
                    smallHead = smallElements;
                } else {
                    smallHead.next = temp;
                    smallHead = smallHead.next;
                }
            }
            else {
                    if (largeElements == null) {
                        largeElements = temp;
                        largeHead = largeElements;
                    } else {
                        largeHead.next = temp;
                        largeHead = largeHead.next;
                        //largeHead.next = null;
                    }
                }
                temp = temp.next;
            }
            smallElements.next = largeElements.next;
            return smallElements;
        }
        */
    //5) Sum lists - Digits stored in reverse order, result in reverse order. Space complexity - O(n), Time complexity - O(n+m)
    Nodes sumlistsReverseOrderIterative(Nodes l1, Nodes l2) {
        Nodes resultsum = new Nodes(0);
        Nodes sumptr = resultsum;
        int carry = 0, sum, tempsum1 = 0, tempsum2 = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                tempsum1 = l1.data;
                l1 = l1.next;
            } else {
                tempsum1 = 0;
            }
            if (l2 != null) {
                tempsum2 = l2.data;
                l2 = l2.next;
            } else {
                tempsum2 = 0;
            }
            sum = tempsum1 + tempsum2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            Nodes newNode = new Nodes(sum);
            sumptr.next = newNode;
            sumptr = sumptr.next;

        }
        if (carry != 0) {
            Nodes newNode = new Nodes(carry);
            sumptr.next = newNode;
            sumptr = sumptr.next;
        }
        Nodes s = resultsum;
        while (s.next != null) {
            s = s.next;
            System.out.println("Sum" + s.data);
        }
        return resultsum;
    }

    //5) Doubt -Sum lists - Digits stored in reverse order, result in reverse order. Space complexity - O(n), Time complexity - O(n+m)
    Nodes sumlistsReverseOrderRecursive(Nodes l1, Nodes l2, int carry) {
        Nodes resultSum = new Nodes(0);
        Nodes resultSumPointer = resultSum;
        //int tempsum1 = 0, tempsum2 = 0;
        int carryValue = carry;
        int newlen = 0;
        int len1 = length(l1);
        int len2 = length(l2);

        if (len1 != len2) {
            newlen = Math.abs(len1 - len2);
            Nodes newlist = (len1 < len2) ? pointerPosition(l1, newlen) : pointerPosition(l2, newlen);
            if (len1 < len2) {
                l1 = newlist;
            }
            else {
                l2 = newlist;
            }
        }


        if (l1 == null && l2 == null & carry == 0) {
            return null;
        }

        if (l1 != null) {
            carryValue = carryValue + l1.data;
        }
        if (l2 != null) {
            carryValue = carryValue + l2.data;
        }
        resultSum.data = carryValue % 10;
        if (l1 != null || l2 != null) {
            Nodes tempResult = sumlistsReverseOrderRecursive(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carryValue >= 10 ? 1 : 0);
            //int tempSum = l1.data + l2.data + carry;
            Nodes tempresult1 = new Nodes(0);
            tempResult = tempresult1;
        }
    return resultSum;
}
//6) Palindrome of linked list. Time - O(n), Space - O(1)
    Boolean palindromeUsingReverseLL(Nodes list) {
        Nodes slowPointer = head;
        Nodes fastPointer = head;
        while(fastPointer != null && fastPointer.next !=null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        if (fastPointer !=null) {
            slowPointer = slowPointer.next;
        }
        Nodes current = slowPointer;
        Nodes nextNode = slowPointer;
        Nodes prev = null;
        while(nextNode != null) {
            nextNode = nextNode.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        while (prev != null) {
            if(head.data != prev.data) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }

//6) Palindrome recursion . Time - , Space -
boolean recursivePalindrome(Nodes mover) {
    temp = head;
    if (mover == null){
        return true;
    }

    boolean part_ans = recursivePalindrome(mover.next);
    boolean ans = part_ans & (mover.data == temp.data);
    temp = temp.next;
    System.out.println(" ans " + ans);
    return ans;
}

    //7) Intersection - Point of intersection of two lists. Return intersecting node. Time - O(n), Space - O(1)
    Nodes intersectionTwoPointers(Nodes list1, Nodes list2, Nodes list3) {
        if(list1 == null || list1.next == null || list2 == null || list2.next == null) {
            return null;
        }
        Nodes temp1 = list1;
        Nodes temp2 = list2;
        while(temp1.next != null) {
            temp1 = temp1.next;
        }
        temp1.next = list3;
        while (temp2.next !=null) {
            temp2 = temp2.next;
        }
        temp2.next = list3;
        if(list1 == null || list2 == null) {
            return null;
        }
        Nodes list1pointer = list1;
        Nodes list2pointer = list2;
        while (list1pointer != list2pointer) {
            if(list1pointer == null) {
                list1pointer = list2;
            }
            else {
                list1pointer = list1pointer.next;
            }
            if(list2pointer == null) {
                list2pointer = list1;
            }
            else {
                list2pointer = list2pointer.next;
            }
        }
        System.out.println(list1pointer.data);
        return list1pointer;
    }

    //7) Intersection - Point of intersection of two lists. Return intersecting node. Time - O(n), Space - O(1)
    Nodes intersectionTwoListsFindingLengthDiff(Nodes list1, Nodes list2, Nodes list3) {
        if(list1 == null || list1.next == null || list2 == null || list2.next == null) {
            return null;
        }
        Nodes temp1 = list1;
        Nodes temp2 = list2;
        while(temp1.next != null) {
            temp1 = temp1.next;
        }
        temp1.next = list3;
        while (temp2.next !=null) {
            temp2 = temp2.next;
        }
        temp2.next = list3;
        int size1 = length(list1);
        int size2 = length(list2);
        int lengthDiff = Math.abs(size1 - size2);
        Nodes longer = (size1 < size2) ? pointerMove(list2, lengthDiff) : pointerMove(list1, lengthDiff);

        if(size1 < size2) {
            list2 = longer;
        }
        else {
            list1 = longer;
        }
        temp1 = list1;
        temp2 = list2;
        while(temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        System.out.println(temp1.data);
        return temp1;
    }

    //7) Intersection - Point of intersection of two lists. Return intersecting node. Time - O(n), Space - O(n)
    Nodes intersectionTwoListsUsingHashing(Nodes list1, Nodes list2, Nodes list3) {
        if(list1 == null || list1.next == null || list2 == null || list2.next == null) {
            return null;
        }
        Nodes temp1 = list1;
        Nodes temp2 = list2;
        while(temp1.next != null) {
            temp1 = temp1.next;
        }
        temp1.next = list3;
        while (temp2.next !=null) {
            temp2 = temp2.next;
        }
        temp2.next = list3;
        HashSet<Nodes> visitedNodes = new HashSet<>();
        temp1 = list1;
        temp2 = list2;
        while (temp1 != null) {
            visitedNodes.add(temp1);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            if (visitedNodes.contains(temp2)) {
                System.out.println(temp2.data);
                return temp2;
            }
            else {
                temp2 = temp2.next;
            }
        }
        return null;
    }

    //8) Loop detection - Return node where loop starts. Time - O(n), Space - O(1)
    Nodes loopDetectionTwoPointers(Nodes list) {
        if(head == null || head.next == null) {
            return null;
        }
        temp = list;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = head.next;

        Nodes shortPointer = head;
        Nodes longPointer = head;
        while (longPointer != null || longPointer.next !=null) {
            if(longPointer == null || longPointer.next == null) {
                return null;
            }
                shortPointer = shortPointer.next;
                longPointer = longPointer.next.next;
                if(shortPointer == longPointer) {
                    break;
                }
        }
        shortPointer = head;
        while (shortPointer != longPointer) {
            shortPointer = shortPointer.next;
            longPointer = longPointer.next;
        }
        System.out.println(shortPointer.data);
        return shortPointer;
    }

    //8) Loop detection - Return node where loop starts. Time - O(n), Space - O(n)
    Nodes circularLoopDetectionHashTable(Nodes list) {
        if(head == null || head.next == null) {
            return null;
        }
        temp = list;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = head.next;

        HashSet<Nodes> visitedNodes = new HashSet<>();

        temp = head;

        while (temp != null || temp.next != null ) {
            if(visitedNodes.contains(list)) {
                break;
            }
            visitedNodes.add(temp);
            temp = temp.next;
        }
        System.out.println(temp.data);
        return temp;
    }

    //Functions to the above problems

    int length(Nodes list) {
        Nodes current = list;
        int size = 1;
        while(current.next != null) {
            size = size+1;
            current = current.next;
        }
        return size;
    }

    Nodes pointerPosition(Nodes list, int lengthDifference) {
        Nodes listPointer = list;
        while (listPointer.next != null) {
            listPointer = listPointer.next;
        }
        while (lengthDifference > 0) {
            Nodes listpointerNode = new Nodes(0);
            listPointer.next = listpointerNode;
            listPointer = listPointer.next;
            lengthDifference--;
        }
        return list;
    }

    Nodes pointerMove(Nodes list, int length) {
        Nodes pointer = list;
        while (length > 0 && pointer != null) {
            length --;
            pointer = pointer.next;
        }
        return pointer;
    }

}



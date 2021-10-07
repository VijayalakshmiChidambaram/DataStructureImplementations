package dataStructureImplementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class TreeDSProblems {
    public static void main(String[] args) {
        TreeNodeImplementation tree = new TreeNodeImplementation();
        TreeNodeImplementation tree1 = new TreeNodeImplementation();
        TreeNodeImplementation.TreeNode root1 = tree.createNode(7);
       /* int[] arr = {1, 2, 3, 4, 5};
        tree.createBST(arr);*/
        TreeNodeImplementation.TreeNode root = tree.createNode(3);
        root.left = tree.createNode(2);
        //root.right = tree.createNode(5);
        root.left.left = tree.createNode(1);
        root.left.right = tree.createNode(6);
        root.left.left.left = tree.createNode(2);
        root.left.right.left = tree.createNode(4);
        /*root.right.left = tree.createNode(6);
        root.right.right = tree.createNode(9);
        root1.left = tree1.createNode(6);
        root1.right = tree1.createNode(9);*/
        tree.leftLeavesSum(root);
        //tree.isSubTree(root, root1);
        /*tree.isSubString(root, root1);
        tree.bstSequences(root);
        root.right.left.right = tree.createNode(13);
        tree.isBalancedBTCheck(root);
        tree.BSTCheck(root);
        tree.BSTCheckUsingVariable(root);
        tree.BSTValid(root);
        tree.sumLeft(root);
        tree.successor(root, root.right.right);
        tree.lcaWithoutParentLink(root, root.left.left, root.left.right.left);
        lca lcaWithParent = new lca();
        Node n = new Node(8);
        //lcaWithParent.insertBS(n, 8);
        lcaWithParent.insertBS(n, 5);
        lcaWithParent.insertBS(n, 10);
        lcaWithParent.insertBS(n, 9);
        lcaWithParent.insertBS(n, 1);
        lcaWithParent.insertBS(n, 12);
        Node n1 = n.left;
        Node n2 = n.left.left;
        lcaWithParent.findLcaWithParent(n1, n2);
        randomNode randomnode = new randomNode(10);
        randomnode.insertNode(5);
        randomnode.insertNode(7);
        randomnode.insertNode(3);
        randomnode.insertNode(15);
        randomnode.insertNode(17);
        randomnode.random();
        randomnode.find(randomnode.left.left);
        randomnode.random();
        randomnode.deleteNode(randomnode.left.left);
        randomnode.random();*/
    }
}

class TreeNodeImplementation {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int dataValue) {
            data = dataValue;
        }
    }

    public TreeNode createNode(int data) {
        TreeNode newNode = new TreeNode(data);
        return newNode;
    }

    public TreeNode createBST(int[] array) {
        if (array == null) {
            return null;
        }
        return minimalTreeBST(array, 0, array.length - 1);
    }

    //1)Give array, create BST with minimal height. Time - O(n). [Time for array of size 'n' - n, C   -->  Constant (Finding middle of array and linking root to left
    //                      and right subtrees take constant time), T(n) = 2T(n/2) +C. Space - O(n) [Due to recursion, stack is used]
    public TreeNode minimalTreeBST(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = minimalTreeBST(array, start, mid - 1);
        root.right = minimalTreeBST(array, mid + 1, end);
        return root;
    }

    //2) Check if a binary tree is balanced. Time - O(n), Space - O(n)
    public boolean isBalancedBTCheck(TreeNode root) {
        if (isbalancedBT(root) != -1) {
            System.out.println("T");
            return true;
        }
        System.out.println("F");
        return false;
    }

    public int isbalancedBT(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = isbalancedBT(node.left);
        int rightHeight = isbalancedBT(node.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        int height = (Math.abs(leftHeight - rightHeight));
        if (height > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //3)Validate BST
    //a)Using Array. Disadvantage - Does not compare the current node with root. Time - O(n), Space - O(n)
    int i = 0;
    int[] arr = new int[7];

    public void validateBST(TreeNode root, int[] array) {
        if (root == null) {
            return;
        }
        validateBST(root.left, arr);
        arr[i] = root.data;
        i++;
        validateBST(root.right, arr);
    }

    public boolean BSTCheck(TreeNode root) {
        validateBST(root, arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    //b)Using variable. Disadvantage - Does not compare the current node with root. Time - O(n), Space - O(1)
    int last_visited = 0;

    public boolean BSTCheckUsingVariable(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!(BSTCheckUsingVariable(root.left))) {
            return false;
        }
        if (last_visited != 0 && last_visited > root.data) {
            return false;
        }
        last_visited = root.data;
        if (!BSTCheckUsingVariable(root.right)) {
            return false;
        }
        return true;
    }

    //c)Using recursion. min,max. Each time compares the root with the subtrees. Time - O(n), Space - O(log n)
    public boolean BSTValid(TreeNode root) {
        return BSTValidation(root, 0, 0);
    }

    boolean BSTValidation(TreeNode n, int min, int max) {
        if (n == null) {
            return true;
        } else if (min != 0 && n.data <= min || max != 0 && n.data > max) {
            return false;
        }
        return BSTValidation(n.left, min, n.data) && BSTValidation(n.right, n.data, max);
    }

    //Sum of left leaves of a tree
    public int sumLeft(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = 0;
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                sum = sum + node.left.data;
            } else {
                sum = sum + sumLeft(node.left);
            }
        }
        if (node.right != null) {
            if (node.right.left != null || node.right.right != null) {
                sum = sum + sumLeft(node.right);
            }
        }
        return sum;
    }

    /*
    if node.ri != null:
    min value in right subtree -> traverse left side of right subtree
    else (Both no/ right no subtree) :
    Return the root of that node as its suc
    Last left turn
     */
//In order successor of a BST.. Time - O(h), h- height of tree(Worst case have to travel deep down the BST). Space - O(1) (No extra DS used)
    public TreeNode successor(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return null;
        } else if (node.right != null) {
            TreeNode temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        } else {
            TreeNode r = root;
            TreeNode newRoot = null;
            while (r != null && r.data != node.data) {
                if (node.data <= r.data) {
                    newRoot = r;
                    r = r.left;
                } else {
                    r = r.right;
                }
            }
            return newRoot;
        }
    }

    /*
    Search if both nodes available:
    Set F1, F2
    return F1 && F2
    If T :
    Look for LCA:
    r == N -> ret N, r==p, r==q -> ret r
    l = recur
    r = recur
    if(l != N && r != N) -> ret r
    else if( l=N && r = N) -> ret N
    else l != N ? l : R
     */
    // Find Lowest Common ancestor - Without link to parent node. Time - O(n) , Space - O(n)
    public TreeNode lcaWithoutParentLink(TreeNode root, TreeNode n1, TreeNode n2) {
        TreeNode lca = null;
        if (lcaSearchNodes(root, n1, n2)) {
            lca = lcaWithoutParent(root, n1, n2);
        }
        return lca;
    }

    boolean node2Flag;
    boolean node1Flag;

    public boolean lcaSearchNodes(TreeNode root, TreeNode n1, TreeNode n2) {
        while ((node1Flag && node2Flag) == false) {
            if (root == null) {
                return false;
            }
            if (root == n1) {
                node1Flag = true;
            }
            if (root == n2) {
                node2Flag = true;
            }
            lcaSearchNodes(root.left, n1, n2);
            lcaSearchNodes(root.right, n1, n2);
            if (node1Flag != true || node2Flag != true) {
                return false;
            }
        }
        return true;
    }

    public TreeNode lcaWithoutParent(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) {
            return null;
        }
        if (root == n1 || root == n2) {
            return root;
        }
        TreeNode left = lcaWithoutParent(root.left, n1, n2);
        TreeNode right = lcaWithoutParent(root.right, n1, n2);
        if (left != null && right != null) {
            return root;
        } else if (left == null && right == null) {
            return null;
        } else {
            return left != null ? left : right;
        }
    }

//BST Sequences - Print all possible arrays that could have led to this tree. Time - O(n^2), Space - O(n)
    public ArrayList<LinkedList<Integer>> bstSequences(TreeNode n) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        if(n == null) {
            result.add(new LinkedList<>());
            return result;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(n.data);
        ArrayList<LinkedList<Integer>> leftLL = bstSequences(n.left);
        ArrayList<LinkedList<Integer>> rightLL = bstSequences(n.right);
        for(LinkedList<Integer> l : leftLL) {
            for(LinkedList<Integer> r : rightLL) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
                weaveList(l, r, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }
    public void weaveList(LinkedList<Integer> l, LinkedList<Integer> r, ArrayList<LinkedList<Integer>> weave, LinkedList<Integer> pre) {
        if(l.size() == 0 || r.size() ==0) {
            LinkedList<Integer> copy = new LinkedList<>();
            copy = (LinkedList<Integer>) pre.clone();
            copy.addAll(l);
            copy.addAll(r);
            weave.add(copy);
            return;
        }
        int leftFirst = l.removeFirst();
        pre.addLast(leftFirst);
        weaveList(l, r, weave, pre);
        pre.removeLast();
        l.addFirst(leftFirst);

        int rightFirst = r.removeFirst();
        pre.addLast(rightFirst);
        weaveList(l, r, weave, pre);
        pre.removeLast();
        r.addFirst(rightFirst);
    }

    //Find a tree is a subtree of another tree
    //1) Using stringbuilder. Time - O(s1+s2). Space - O(s1+s2)
    /* StringBuilder s1,s2
    if(s1.contains(s2) || s2.contains(s1)) -> T
    rec(t1,t2) {
     t1 || t2 == null : append x
     s1.append(nodes) || s2.append(nodes)
    }
     */
    public boolean isSubString(TreeNode t1, TreeNode t2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        s1 = checkSubstring(t1, s1);
        s2 = checkSubstring(t2, s2);
        return (s1.indexOf(s2.toString())) != -1;

    }
    public StringBuilder checkSubstring(TreeNode t, StringBuilder s) {
        if(t == null) {
            s.append('x');
            return null;
        }
        s.append(t.data);
        checkSubstring(t.left, s);
        checkSubstring(t.right, s);
        return s;
    }
    //2. Using recursion. Time - O(n1*n2), Space(log n1 +log n2)
    /*
    t2 - is subtree of t1
    t2 == null -> T
    rec(t1,t2) :
    if(t1 == null) -> F
    else if((t1.data == t2.data) && match(t1,t2)) -> T
    else rec(t1.left,t2) || rec(t1.right,t2) -> F
    match(n1,n2)
    if(n1 = N && n2 = N) -> T
    n1= N || n2 = N -> F
    match(n1.left, n2.left) && match(n1.right, n2.right)
     */
    public boolean isSubTree(TreeNode n1, TreeNode n2) {
        if(n2 == null) {
            return true;
        }
        return subTreeCheck(n1,n2);
    }
    public boolean subTreeCheck(TreeNode t1, TreeNode t2) {
        if(t1 == null) {
            return false;
        }
        else if((t1.data == t2.data) && matchTree(t1,t2)) {
            return true;
        }
        else {
            return subTreeCheck(t1.left,t2) || subTreeCheck(t1.right,t2);
        }
    }
    public boolean matchTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
    }


    public int leftLeavesSum(TreeNode node) {
        int sum = 0;
        if(node == null) {
            return 0;
        }
        if(node.left != null) {
            /*if(node.left.left == null && node.left.right == null) {
                sum += node.left.data;
            }
            else {
                sum += leftLeavesSum(node.left);
            }*/
            if(node.left.left != null || node.left.right !=null) {
                sum = sum + leftLeavesSum(node.left);
            }
            else {
                sum = sum + node.left.data;
            }
        }
        if(node.right != null) {
            if(node.right.left != null || node.right.right != null) {
                sum += leftLeavesSum(node.right);
            }
        }
        return sum;

    }

}

/* Find Lowest Common ancestor - With link to parent node. Time - O(n) n - no. of nodes in tree, Space - O(1)
        */

    class Node {
        int data;
        Node left;
        Node right;
        Node parent;

        public Node(int data) {
            this.data = data;
        }
    }
class lca {
    public Node insertBS(Node n, int key) {
        if(n == null) {
        return new Node(key);
        }
        else if(key <= n.data) {
            n.left = insertBS(n.left, key);
            n.left.parent = n;
        }
        else {
            n.right = insertBS(n.right, key);
            n.right.parent = n;
        }
        return n;
    }
/*
n1,n2 = len
diff = n1-n2
> in n1,n2 move up to it parent to value in diff
Move n1, n2 together, till their address are same
 */
    public Node findLcaWithParent(Node n1, Node n2) {
        int len1 = length(n1);
        int len2 = length(n2);
        int difference = Math.abs(len1 - len2);
        Node shallow = len1 < len2 ? n1 : n2;
        Node deep = len1 > len2 ? n1 : n2;
        while (difference != 0) {
            deep = deep.parent;
            difference--;
        }
        while (shallow != deep && shallow!=null && deep != null) {
            shallow = shallow.parent;
            deep = deep.parent;
        }
        return deep;
    }
    public int length(Node n) {
        int l=0;
        while(n.parent != null) {
            l++;
            n = n.parent;
        }
        return l;
    }
    }
/*
ClassNode : data,L,R,size
Ins(element) :
element <= data:
    L = Null :
        L = element -> classNode
    L.Ins(element)
else :
same -> R

Find(element) :
if(N) : return N
element == data:
return this
element <= data :
    L.find(element)
elem > data :
    R.find(element)

Del(element) :
element <= data :
    L.del(element)
element > data :
    R.del(element)
element == data :
    1)data.L == N && data.R == Null
        data == N
    2) data.L !=N
        data = data.L
    3) data.R !=N
        data = data.R
    4) data.L != N && data.R !=N
        Node nd = Min(data.R)
        data = nd;
        R.del(nd);

Min(Node r) {
r.left == N :
  return this;
ret Min(r.l)
}

randomNode() :
int index : rand.nextInt(size)
getNode(index);

getNode(int i) :
int ls = L == N ? 0 : L.size();
if(i<=ls) :
ret L.getNode(i);
i == ls :
ret this;
i > ls
ret getNode(i-(ls+1))
 */
// Random Node - In addition to insert, del, find we will have getRandomNode which returns random node from tree. Time - O(log n) - if tree is balanced, O(n)- n is depth of the tree. Space - O(n) - space for storing stack calls
class randomNode {
        int data;
        randomNode left;
        randomNode right;
        private int size = 0;
        public randomNode(int d) {
            data = d;
            size = 1;
        }
    public void insertNode(int d) {
        if(d <= data) {
            if (left == null) {
                left = new randomNode(d);
            } else {
                left.insertNode(d);
            }
        }
        else {
            if(right == null) {
                right = new randomNode(d);
            }
            else {
                right.insertNode(d);
            }
        }
        size++;
    }
    public int getSize()
     {
         return size;
     }
     public int data() {
         return data;
     }
     public randomNode find(randomNode d) {
         if(d == null) {
             return null;
         }
         if(data == d.data) {
             return this;
         }
         else if(d.data < data) {
             return left.find(d);
         }
         else {
             return right.find(d);
         }
     }
     public randomNode deleteNode(randomNode d) {
         if(d == null) {
             return null;
         }
         else if(d.data < data) {
             return left.deleteNode(d);
         }
         else if(d.data > data) {
             return right.deleteNode(d);
         }
         else {
             if (d.left == null && d.right == null) {
                 d = null;
             }
             else if(d.left != null && d.right == null) {
                 d = d.left;
             }
             else if(d.right != null && d.left == null) {
                 d = d.right;
             }
             else {
                 randomNode rd = minimumValue(d.right);
                 d = rd;
                 right.deleteNode(rd);
             }
             return d;
         }
     }

     public randomNode minimumValue(randomNode d) {
         if(d.left == null) {
             return d;
            }
         return left.minimumValue(d);
     }

     public randomNode random() {
         Random rand = new Random();
         int index = rand.nextInt(getSize());
         return getithNode(index);
     }
     public randomNode getithNode(int i){
         int leftSize = left == null ? 0 : left.getSize();
         if (i < leftSize) {
             return left.getithNode(i);
         }
         else if (i == leftSize) {
             return this;
         }
         else {
             return right.getithNode(i -(leftSize+1));
         }
     }

     /* pathSum(Node n, int s):
     if(r == N) -> N
     int pathRoot = totalPath(Node n, int targetS => , int currS =>0)
     int leftPath = pathSum(Node n, int s)
     int rightPath = pathSum(n, s)
     ret path + lP + rP
     totalPath(Node n, int targetS => , int currS =>0):
     if(n = N)  ret 0;
     currS = cS + n.data;
     int totPath = 0;
     if(cS == tS) {
     totP++;
     }
     totP = totP + totPath(n.left,,)
     totP = totP + totPath(n.r,,)
     ret totP;
      */
    //Calculate paths with given sum. Time - O(n^2), Space - O(n)
     public int pathSum(randomNode r, int sum) {
         if(r == null) {
             return 0;
         }
         int rootPath = pathCalculation(r, sum, 0);
         int leftPath = pathSum(r.left, sum);
         int rightPath = pathSum(r.right, sum);
         return rootPath+leftPath+rightPath;

     }
     public int pathCalculation(randomNode r, int targetSum, int currSum) {
         if(r == null) {
             return 0;
         }
         currSum = currSum+ r.data;
         int totalPath = 0;
         if(currSum <= targetSum) {
             if(currSum == targetSum) {
                 totalPath++;
             }
             totalPath = totalPath + pathCalculation(r.left, targetSum, currSum);
             totalPath = totalPath + pathCalculation(r.right, targetSum, currSum);
         }
         return totalPath;
     }

     //PathSum using HashTable

    /*int getBinaryTreeHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = getBinaryTreeHeight(node.left);
        int rightHeight = getBinaryTreeHeight(node.right);

        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }*/
}
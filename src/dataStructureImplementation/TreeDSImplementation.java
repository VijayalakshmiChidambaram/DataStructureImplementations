package dataStructureImplementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class TreeDSImplementation {
    public static void main(String[] args) {
        binarayTreeDS treeDS = new binarayTreeDS();
        binarayTreeDS treeDS1 = new binarayTreeDS();
        /*binarayTreeDS.TreeNode root = treeDS.createTreeNode(4);
        root.left = treeDS.createTreeNode(5);
        root.right = treeDS.createTreeNode(10);
        root.left.left = treeDS.createTreeNode(7);
        root.left.right = treeDS.createTreeNode(8);
        root.right.right = treeDS.createTreeNode(1);
        treeDS.preorder(root);
        treeDS.inorderTraversal(root);
        treeDS.postOrderTraversal(root);*/
        treeDS.binarySearchTreeInsertion(8);
        treeDS.binarySearchTreeInsertion(5);
        treeDS.binarySearchTreeInsertion(7);
        treeDS.binarySearchTreeInsertion(10);
        treeDS.binarySearchTreeInsertion(17);
        treeDS.binarySearchTreeInsertion(1);
        /*treeDS.binarySearchTreeInsertion(4);
        treeDS.binarySearchTreeSearch(treeDS.root, 4);
        treeDS.binarySearchTreeDeletion(treeDS.root, 5);
        treeDS.isBalanced(treeDS.root);*/
        Question question = new Question();
        //question.allSequences(treeDS.root);
        treeDS1.binarySearchTreeInsertion(5);
        treeDS1.binarySearchTreeInsertion(7);
        treeDS1.binarySearchTreeInsertion(1);
        question.checkSubtree(treeDS.root, treeDS1.root);
    }

}

class binarayTreeDS {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int dataValue) {
            data = dataValue;
        }
    }

    public TreeNode createTreeNode(int data) {
        TreeNode newNode = new TreeNode(data);
        return newNode;
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }

    TreeNode root;

    public TreeNode binarySearchTreeInsertion(int data) {
        TreeNode newNodeBST = createTreeNode(data);
        if (root == null) {
            root = newNodeBST;
        } else {
            TreeNode newroot = root;
            while(newNodeBST!=null) {
            if (newNodeBST.data < newroot.data) {
                if (newroot.left == null) {
                    newroot.left = newNodeBST;
                    newNodeBST = null;
                } else {
                    newroot = newroot.left;
                }
            }
            else if(newNodeBST.data > newroot.data) {
                if(newroot.right == null) {
                    newroot.right = newNodeBST;
                    newNodeBST = null;
                }
                else {
                    newroot = newroot.right;
                }
            }

            }
        }
        return root;
    }

    public TreeNode binarySearchTreeSearch(TreeNode root, int key) {
        if (root == null || root.data == key) {
            return root;
        }
        else {
            if(key < root.data) {
                return binarySearchTreeSearch(root.left, key);
            }
            else {
                return binarySearchTreeSearch(root.right, key);
            }
        }
    }

    public TreeNode binarySearchTreeDeletion(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        else if(key < root.data) {
            root.left = binarySearchTreeDeletion(root.left, key);
        }
        else if(key > root.data) {
            root.right = binarySearchTreeDeletion(root.right, key);
        }
        else {
            if(root.left != null && root.right!= null) {
                TreeNode temp = root;
                TreeNode min = minimumValue(temp.right);
                root.data = min.data;
                root.right = binarySearchTreeDeletion(root.right,min.data);
            }
            else if(root.left != null) {
                root = root.left;
            }
            else if(root.right != null) {
                root = root.right;
            }
            else {
                root = null;
            }
        }
        return root;
    }
    public TreeNode minimumValue(TreeNode node) {
        if(node.left == null) {
            return node;
        }
        else {
            return minimumValue(node.left);
        }
    }

    public boolean isBalanced(TreeNode n) {
        if (balancedHeight(n) > -1) return true;
        return false;
    }

    public int balancedHeight(TreeNode n) {
        if (n == null) return 0;
        int leftHeight = balancedHeight(n.left);
        int rightHeight = balancedHeight(n.right);


        if (leftHeight == -1 || rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        if (leftHeight > rightHeight) return leftHeight + 1;
        return rightHeight + 1;
    }
}
class Question {

    public void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        /* One list is empty. Add the remainder to [a cloned] prefix and
         * store result. */
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        /* Recurse with head of first added to the prefix. Removing the
         * head will damage first, so we’ll need to put it back where we
         * found it afterwards. */
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        /* Do the same thing with second, damaging and then restoring
         * the list.*/
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

    public ArrayList<LinkedList<Integer>> allSequences(binarayTreeDS.TreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

        if (node == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.data);

        /* Recurse on left and right subtrees. */
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        /* Weave together each list from the left and right sides. */
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    public void checkSubtree(binarayTreeDS.TreeNode t1, binarayTreeDS.TreeNode t2) {
        if(t1 == null || t2 == null) {
            return;
        }
        if(t1.data == t2.data) {
            if(subtreeCheck(t1, t2)) {
                return;
            }
        }
        checkSubtree(t1.left, t2);
        checkSubtree(t1.right, t2);
    }
    public boolean subtreeCheck(binarayTreeDS.TreeNode n1, binarayTreeDS.TreeNode n2) {
        if(n1 == null && n2 == null) {
            return true;
        }
        if(n1.data != n2.data) {
            return false;
        }
        subtreeCheck(n1.left, n2.left);
        subtreeCheck(n1.right, n2.right);
        return true;
    }
}
class TreeNode {
    private int data;
    public TreeNode left;
    public TreeNode right;
    private int size = 0;

    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    public TreeNode getRandomNode() {
        int leftSize =left == null ? 0 : left.size();
        Random random = new Random();
        int index = random.nextInt(size);
        if (index < leftSize) {
            return left.getRandomNode();
        } else if (index == leftSize) {
            return this;
        } else {
            return right.getRandomNode();
        }
    }

    public void insertinOrder(int d) {
        if (d <= data) {
            if (left == null) {
                left = new TreeNode(d);
            } else {
                left.insertinOrder(d);
            }
        } else {
            if (right == null) {
                right = new TreeNode(d);
            } else {
                right.insertinOrder(d);
            }
        }
        size++;
    }

    public int size() {
        return size;
    }
    public int data() {
        return data;
    }

    public TreeNode find(int d) {
        if (d == data) {
            return this;
        } else if (d <= data) {
            return left != null ? left.find(d) : null;
        } else if (d > data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }
}
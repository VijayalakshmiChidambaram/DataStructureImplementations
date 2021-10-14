package dataStructureImplementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TreeDSImplementation {
    public static void main(String[] args) {
        binarayTreeDS treeDS = new binarayTreeDS();
        //binarayTreeDS treeDS1 = new binarayTreeDS();
        binarayTreeDS.TreeNode root = treeDS.createTreeNode(5);
        root.left = treeDS.createTreeNode(3);
        root.right = treeDS.createTreeNode(7);
        root.left.left = treeDS.createTreeNode(1);
        root.left.right = treeDS.createTreeNode(4);
        //root.right.left = treeDS.createTreeNode(6);
        //root.right.right = treeDS.createTreeNode(9);
        /*treeDS.treeHeight(root);
        treeDS.preorder(root);
        treeDS.inorderTraversal(root);
        treeDS.postOrderTraversal(root);
        treeDS.binarySearchTreeInsertion(8);
        treeDS.binarySearchTreeInsertion(5);
        treeDS.binarySearchTreeInsertion(7);
        treeDS.binarySearchTreeInsertion(10);
        treeDS.binarySearchTreeInsertion(17);
        treeDS.binarySearchTreeInsertion(1);*/
        /*treeDS.binarySearchTreeInsertion(4);
        treeDS.binarySearchTreeSearch(treeDS.root, 4);
        treeDS.binarySearchTreeDeletion(treeDS.root, 5);
        treeDS.isBalanced(treeDS.root);
        Question question = new Question();
        question.allSequences(root);
        treeDS1.binarySearchTreeInsertion(5);
        treeDS1.binarySearchTreeInsertion(7);
        treeDS1.binarySearchTreeInsertion(1);
        question.checkSubtree(treeDS.root, treeDS1.root);
        TreeNodes t = new TreeNodes(10);
        t.insertinOrder(5);
        t.insertinOrder(7);
        t.insertinOrder(3);
        t.insertinOrder(15);
        t.insertinOrder(17);
        t.getRandomNode();
        t.getRandomNode();
        t.getRandomNode();*/

        invertTree in = new invertTree(1);
        in.left = new invertTree(2);
        in.right = new invertTree(3);
        in.left.right = new invertTree(4);

        invertTreefunction invertTreefunction = new invertTreefunction();
        //invertTreefunction.invertBT(in);
        invertTreefunction.levelOrder(in);
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
    public int treeHeight(TreeNode node) {
        if(node == null) {
            return -1;
        }
        int left = treeHeight(node.left);
        int right = treeHeight(node.right);

        if(left > right) {
            return left +1;
        }
        else {
            return right+1;
        }
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
class TreeNodes {
    private int data;
    public TreeNodes left;
    public TreeNodes right;
    private int size = 0;

    public TreeNodes(int d) {
        data = d;
        size = 1;
    }

    public TreeNodes getRandomNode() {
        //int leftSize =left == null ? 0 : left.size();
        if(size == 0) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(size);
        /*if (index < leftSize) {
            return left.getRandomNode();
        } else if (index == leftSize) {
            System.out.println(index + "" + this.data);
            return this;
        } else {
            return right.getRandomNode();
        }*/
        return getIthNode(index);
    }

    public void insertinOrder(int d) {
        if (d <= data) {
            if (left == null) {
                left = new TreeNodes(d);
            } else {
                left.insertinOrder(d);
            }
        } else {
            if (right == null) {
                right = new TreeNodes(d);
            } else {
                right.insertinOrder(d);
            }
        }
        size++;
    }
    /*
                10
               /  \
             5     15
           /  \       \
          3    7       17

*/
    public int size() {
            return size;
    }
    public int data() {
        return data;
    }

    public TreeNodes getIthNode(int i) {
        int leftSize =left == null ? 0 : left.size();
        if (i < leftSize) {
            return left.getIthNode(i);
        } else if (i == leftSize) {
            System.out.println(i + "" + this.data);
            return this;
        } else {
            return right.getIthNode(i -(leftSize + 1));
        }
    }
    public TreeNodes find(int d) {
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
class invertTree {
    int val;
    invertTree left;
    invertTree right;

    public invertTree(int val) {
        this.val = val;
    }
}
class invertTreefunction {
    public invertTree invertBT(invertTree root) {
        /*if(root == null) {
            return null;
        }*/
        if(root.left == null && root.right == null) {
            return null;
        }

        invertTree tempLeft = root.left;
        root.left = root.right;
        root.right = tempLeft;

        invertBT(root.left);
        invertBT(root.right);

        return root;
    }
    public List<List<Integer>> levelOrder(invertTree root) {
        List<List<Integer>> output = new ArrayList<>();
        levelOrderHelper(output, root, 0);
        return output;
    }

    public void levelOrderHelper(List<List<Integer>> output, invertTree root, int level) {
        if (root == null) {
            return;
        } else {
            if (level >= output.size()) {
                output.add(new ArrayList<>());
            }
            output.get(level).add(root.val);
            levelOrderHelper(output, root.left, level + 1);
            levelOrderHelper(output, root.right, level + 1);
        }
    }

    // Time - O(n) -> Visit all nodes, Space - O(n) -> Recursive calls
    public List<List<Integer>> findLeaves(invertTree root) {
        List<List<Integer>> output = new ArrayList<>();
        leavesCollect(root, output);
        return output;
    }
    public int leavesCollect(invertTree node, List<List<Integer>> output) {
        if(node == null) {
            return -1;
        }
        int left = leavesCollect(node.left, output);
        int right = leavesCollect(node.right, output);

        int level = Math.max(left, right) + 1;
        if(level == output.size()) {
            output.add(new ArrayList());
        }
        output.get(level).add(node.val);
        //node.left = null;
        //node.right = null;

        return level;
    }
}
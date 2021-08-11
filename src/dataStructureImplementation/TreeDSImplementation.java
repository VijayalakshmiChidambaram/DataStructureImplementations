package dataStructureImplementation;

import com.sun.source.tree.Tree;

import java.util.Scanner;

public class TreeDSImplementation {
    public static void main(String[] args) {
        binarayTreeDS treeDS = new binarayTreeDS();
        /*binarayTreeDS.TreeNode root = treeDS.createTreeNode(4);
        root.left = treeDS.createTreeNode(5);
        root.right = treeDS.createTreeNode(10);
        root.left.left = treeDS.createTreeNode(7);
        root.left.right = treeDS.createTreeNode(8);
        root.right.right = treeDS.createTreeNode(1);*/
        //treeDS.preorder(root);
        //treeDS.inorderTraversal(root);
        //treeDS.postOrderTraversal(root);
        treeDS.binarySearchTreeInsertion(8);
        treeDS.binarySearchTreeInsertion(5);
        treeDS.binarySearchTreeInsertion(10);
        treeDS.binarySearchTreeInsertion(7);
        treeDS.binarySearchTreeInsertion(17);
        treeDS.binarySearchTreeInsertion(1);
        treeDS.binarySearchTreeInsertion(4);
        //treeDS.binarySearchTreeSearch(treeDS.root, 4);
        treeDS.binarySearchTreeDeletion(treeDS.root, 5);
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
                root.right = binarySearchTreeDeletion(root.right, min.data);
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
}
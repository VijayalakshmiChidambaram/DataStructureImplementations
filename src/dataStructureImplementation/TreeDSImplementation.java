package dataStructureImplementation;

import com.sun.source.tree.Tree;

import java.util.Scanner;

public class TreeDSImplementation {
    public static void main(String[] args) {
        binarayTreeDS treeDS = new binarayTreeDS();
        binarayTreeDS.TreeNode root = treeDS.createTreeNode(4);
        root.left = treeDS.createTreeNode(5);
        root.right = treeDS.createTreeNode(10);
        root.left.left = treeDS.createTreeNode(7);
        root.left.right = treeDS.createTreeNode(8);
        root.right.right = treeDS.createTreeNode(1);
        //treeDS.preorder(root);
        treeDS.inorderTraversal(root);
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
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public void inorderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }
}
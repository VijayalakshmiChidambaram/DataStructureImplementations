package dataStructureImplementation;

import java.util.Scanner;

public class TreeDSImplementation {
    public static void main(String[] args) {
        binarayTreeDS treeDS = new binarayTreeDS();
        binarayTreeDS.TreeNode root = treeDS.createTreeNode(1);
        root.left = treeDS.createTreeNode(2);
        root.right = treeDS.createTreeNode(3);
        root.left.right = treeDS.createTreeNode(5);
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
}
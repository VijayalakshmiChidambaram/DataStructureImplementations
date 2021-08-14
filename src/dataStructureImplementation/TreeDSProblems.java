package dataStructureImplementation;

public class TreeDSProblems {
    public static void main(String[] args) {
        TreeNodeImplementation tree = new TreeNodeImplementation();
       /* int[] arr = {1, 2, 3, 4, 5};
        tree.createBST(arr);*/
        TreeNodeImplementation.TreeNode root = tree.createNode(8);
        root.left = tree.createNode(3);
        root.right = tree.createNode(10);
        root.left.left = tree.createNode(1);
        root.left.right = tree.createNode(6);
        root.left.right.left = tree.createNode(4);
        root.left.right.right = tree.createNode(7);
        tree.isBalancedBTCheck(root);
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

    public TreeNode createNode(int data)
    {
        TreeNode newNode = new TreeNode(data);
        return newNode;
    }

    public TreeNode createBST(int[] array)
    {
        if(array==null) {
            return null;
        }
        return minimalTreeBST(array, 0, array.length -1);
    }

    //1)Give array, create BST with minimal height. Time - O(n). [Time for array of size 'n' - n, C   -->  Constant (Finding middle of array and linking root to left
    //                      and right subtrees take constant time), T(n) = 2T(n/2) +C. Space - O(n) [Due to recursion, stack is used]
    public TreeNode minimalTreeBST(int[] array, int start, int end) {
    if(end < start) {
        return null;
    }
    int mid = (start + end)/2;
    TreeNode root = new TreeNode(array[mid]);
    root.left = minimalTreeBST(array, start, mid-1);
    root.right = minimalTreeBST(array, mid+1, end);
    return root;
    }

    //2) Check if a binary tree is balanced
    public boolean isBalancedBTCheck(TreeNode root ) {
        if(isbalancedBT(root)!= -1) {
            System.out.println("T");
            return true;
        }
        System.out.println("F");
        return false;
    }
    public int isbalancedBT(TreeNode node){
        if(node == null) {
            return 0;
        }
        int leftHeight = isbalancedBT(node.left);
        int rightHeight = isbalancedBT(node.right);
        if(leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        int height = (Math.abs(leftHeight-rightHeight));
        if(height > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
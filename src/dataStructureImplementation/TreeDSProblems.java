package dataStructureImplementation;

public class TreeDSProblems {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        TreeNodeImplementation tree = new TreeNodeImplementation();
        tree.createBST(arr);

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
    public TreeNode createBST(int[] array)
    {
        if(array==null) {
            return null;
        }
        return minimalTreeBST(array, 0, array.length -1);
    }

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
}
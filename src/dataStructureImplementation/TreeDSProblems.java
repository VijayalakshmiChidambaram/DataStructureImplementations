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
        root.left.right = tree.createNode(5);
        //root.left.right.left = tree.createNode(4);
        //root.left.right.right = tree.createNode(9);
        root.right.left = tree.createNode(9);
        root.right.right = tree.createNode(14);
        //root.right.left.right = tree.createNode(13);
        /*tree.isBalancedBTCheck(root);
        tree.BSTCheck(root);
        tree.BSTCheckUsingVariable(root);
        tree.BSTValid(root);
        tree.sumLeft(root);*/
        tree.successor(root, root.right.right);
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

    //2) Check if a binary tree is balanced. Time - O(n), Space - O(n)
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

    //3)Validate BST
    //a)Using Array. Disadvantage - Does not compare the current node with root. Time - O(n), Space - O(n)
    int i =0;
    int[] arr = new int[7];
    public void validateBST(TreeNode root, int[] array) {
        if(root == null) {
            return;
        }
        validateBST(root.left, arr);
        arr[i] = root.data;
        i++;
        validateBST(root.right, arr);
    }
    public boolean BSTCheck(TreeNode root) {
        validateBST(root, arr);
        for(int i=1; i<arr.length; i++) {
            if(arr[i] <= arr[i-1]) {
                return false;
            }
        }
        return true;
    }

    //b)Using variable. Disadvantage - Does not compare the current node with root. Time - O(n), Space - O(1)
    int last_visited = 0;
    public boolean BSTCheckUsingVariable(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(!(BSTCheckUsingVariable(root.left))) {
            return false;
        }
        if(last_visited !=0 && last_visited > root.data) {
            return false;
        }
        last_visited = root.data;
        if(!BSTCheckUsingVariable(root.right)) {
            return false;
        }
        return true;
    }
    //c)Using recursion. min,max. Each time compares the root with the subtrees. Time - O(n), Space - O(log n)
    public boolean BSTValid(TreeNode root) {
        return BSTValidation(root, 0, 0);
    }
     boolean BSTValidation(TreeNode n, int min, int max) {
        if(n == null) {
            return true;
        }
        //Vimal ask max update
        else if(min !=0 && n.data <= min || max != 0 && n.data > max) {
            return false;
        }
        return BSTValidation(n.left, min, n.data) && BSTValidation(n.right, n.data, max);
     }
//Sum of left leaves of a tree
    public int sumLeft(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int sum = 0;
        if(node.left != null) {
            if(node.left.left == null && node.left.right == null) {
                sum = sum + node.left.data;
            }

            else {
                sum = sum + sumLeft(node.left);
            }
        }
        if(node.right != null) {
            if(node.right.left != null || node.right.right != null) {
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

    public TreeNode successor(TreeNode root, TreeNode node) {
        if(root == null || node == null) {
            return null;
        }
        else if(node.right != null) {
            TreeNode temp = node.right;
            while(temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
        else {
            TreeNode r = root;
            TreeNode newRoot = null;
            while(r != null && r.data != node.data) {
                if(node.data <= r.data) {
                    newRoot = r;
                    r = r.left;
                }
                else {
                    r = r.right;
                }
            }
            return newRoot;
        }
    }
}
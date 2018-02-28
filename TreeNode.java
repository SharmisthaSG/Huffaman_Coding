/**
 * This represents a Node in PriorityQueue
 */
public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    /**
     * Default constructor
     * Sets data to 0
     */
    public TreeNode() {
        this.data = 0;
        left = null;
        right = null;
    }

    /**
     *
     * @param data represents the data to be stored in the Node
     */
    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    /**
     * Prints the inorder travel of the HuffmanTree tree whose root node is given by root
     * @param root root node of the HuffmanTree
     */
    public void inOrder(TreeNode root) {

        if (root != null) {
            inOrder(root.left);
            System.out.print(" " + root.data);
            inOrder(root.right);
        }
    }
}


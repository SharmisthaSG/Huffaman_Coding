/**
 * Priority Queue data structure(trimmed down for this problem) implemented from scratch.
 *
 * Complexity of operations
 * insert: O(n)
 * remove: 1
 *
 * NOTE: This implementation doesn't support dynamic resizing of capacity of array
 */
public class PriorityQueue {

    private TreeNode[] arr; // Array to store the elements in the queue
    private int nItems; // number of elements in the queue

    /**
     * A constructor that makes an empty queue of MAX CAPACITY = size
     *
     * @param size Max size of the queue.
     */
    PriorityQueue(int size) {

        // initialising array
        this.arr = new TreeNode[size];

        // initialising each element of the array
        for (int i = 0; i < size; i++) {
            this.arr[i] = new TreeNode();
        }

        // number of items is 0 initially
        this.nItems = 0;
    }


    /**
     * A function to insert an element in the Queue
     *
     * @param node TreeNode to insert to the PriorityQueue
     */
    public void insert(TreeNode node) {

        // Overflow check
        if(nItems == arr.length)
            return;

        // adding element to the array
        arr[nItems++] = node;

        // making sure that the largest element is on the top, index 0
        for (int j = nItems - 1; j > 0; j--) {

            if (arr[j].data > arr[j - 1].data) {
                // swap j and j-1 elements
                TreeNode temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            } else {
                break;
            }

        }

    }

    /**
     * A function that dequeues
     *
     * @return the top element the Queue and remove it
     */
    public TreeNode remove() {
        if(nItems > 0)
            return arr[--nItems];
        else
            // Underflow
            return null;
    }

    /**
     *  Displays all the elements in the queue
     */
    public void display() {
        for (int i = 0; i < nItems; i++) {
            System.out.println(arr[i].data + " ");
        }
    }

    /**
     * @return the number of elements in the queue
     */
    public int size() {
        return nItems;
    }

    /**
     *
     * @return the top element in the queue without removing it
     */
    public TreeNode peek(){
        return arr[0];
    }
}



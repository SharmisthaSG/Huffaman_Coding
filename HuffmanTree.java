/**
 *
 */
public class HuffmanTree {

    int total;

    public void insert_tree(PriorityQueue pq) {

        while (pq.size() > 1) {
            TreeNode min_a = pq.remove();
            TreeNode min_b = pq.remove();
            TreeNode tmp = new TreeNode(min_a.data + min_b.data);
            tmp.right = min_a;
            tmp.left = min_b;
            pq.insert(tmp);
        }
    }

    public void countbits(TreeNode root, int count) {
        if (root.left == null && root.right == null) {
            total += count * root.data;
        } else {
            countbits(root.left, count + 1);
            countbits(root.right, count + 1);
        }
    }
}

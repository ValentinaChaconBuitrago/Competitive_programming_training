/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    private Queue<TreeNode> queue;

    public void inorder(TreeNode node){
        if(node==null)return;
        inorder(node.left);
        queue.add(node);
        inorder(node.right);
    }

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        inorder(root);
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll().val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(queue.size()>0)return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
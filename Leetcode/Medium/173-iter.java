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
    public Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode current = stack.pop();
        int num = current.val;
        current = current.right;
        while(current!=null){
            stack.push(current);
            current = current.left;
        }

        return num;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(stack.size()>0)return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
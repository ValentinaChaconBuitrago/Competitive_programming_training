/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans  = new ArrayList<>();
        if(root==null)return ans;
        
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        
        while(!nodeStack.empty()){
            TreeNode top = nodeStack.peek();
            ans.add(top.val);
            nodeStack.pop();
            if(top.right!=null) nodeStack.push(top.right);
            if(top.left!=null) nodeStack.push(top.left);
        }
        
        return ans;
    }
}
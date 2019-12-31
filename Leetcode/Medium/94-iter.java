/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode current = root;
            
        while(current!=null||!nodeStack.empty()){
            while(current != null){
                nodeStack.push(current);
                current = current.left;
            }
            
            current = nodeStack.pop();
            ans.add(current.val);
            current=current.right;
        }
    
        return ans;
    }
}
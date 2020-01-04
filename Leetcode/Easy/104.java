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
    private int ans;
    public void findDepth(TreeNode node, int depth){
        if(node==null)return;
        ans = Math.max(ans,depth);
        findDepth(node.left,depth+1);
        findDepth(node.right,depth+1);
    }
    
    public int maxDepth(TreeNode root) {
        ans = 0;
        findDepth(root,1);
        return ans;
    }
}
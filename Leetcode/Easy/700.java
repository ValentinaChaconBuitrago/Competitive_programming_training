/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode findValue(TreeNode node, int val){
        if(node==null)return null;

        if(node.val<val)return findValue(node.right,val);
        else if(node.val>val)return findValue(node.left,val);

        return node;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        return findValue(root,val);
    }
}
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
    public boolean isLeaf(TreeNode node){
        if(node.left==null && node.right==null)return true;
        return false;
    }
    public boolean findSame(TreeNode node, int sum, int acum){
        if(isLeaf(node))return sum==acum;
        boolean left = false;
        boolean right = false;
        if(node.left!=null){
            left = findSame(node.left,sum,acum+node.left.val);
        }
        if(node.right!=null){
            right = findSame(node.right,sum,acum+node.right.val);
        }
        return left||right;
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)return false;
        return findSame(root,sum,root.val);
    }
}
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode current = root;
        while(current!=null){
            if(current.val>val){
                if(current.left==null){
                    TreeNode insertedNode = new TreeNode(val);
                    current.left=insertedNode;
                    return root;
                }
                current=current.left;
            }
            else if(current.val<val){
                if(current.right==null){
                    TreeNode insertedNode = new TreeNode(val);
                    current.right=insertedNode;
                    return root;
                }
                current=current.right;
            }
        }
        return root;
    }
}
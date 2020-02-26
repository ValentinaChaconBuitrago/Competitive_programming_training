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

    static TreeNode rootList;

    static void getFlattened(TreeNode node){
        if(node==null)return;

        //Keep looking for values in the tree
        getFlattened(node.right);
        getFlattened(node.left);

        node.right=rootList;
        node.left = null;
        rootList = node;
    }


    public void flatten(TreeNode root) {
        rootList = null;
        getFlattened(root);
    }
}
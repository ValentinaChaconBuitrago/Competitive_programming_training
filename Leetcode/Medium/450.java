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

//Case 1: the node only has a right child
//Case 2: the node only has a left child
//Case 3: the node has both children --> look for succcessor
//Successor node: smallest value greater than the current value
class Solution {
    public TreeNode minValue(TreeNode node){
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

        if(root.val>key) root.left = deleteNode(root.left, key);
        else if(root.val<key) root.right = deleteNode(root.right, key);
        else{
            //Case 1
            if(root.left==null) return root.right;
            //Case 2
            else if(root.right==null) return root.left;
            //Case 3
            else{
                //Look for the right subtree of the current node
                TreeNode successor = minValue(root.right);
                root.val = successor.val;
                root.right = deleteNode(root.right, root.val);
            }

        }
        return root;
    }
}

//Time complexity O(height): in the worst case it requires time proportional to the height of the tree. It does not require more even when the node has two children, since it still follows a single path and does not visit any node twice
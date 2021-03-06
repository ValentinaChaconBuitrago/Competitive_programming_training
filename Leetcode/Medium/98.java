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
    //Inorder: left,root,right
    public void inorder(TreeNode node, List<Integer> list){
        if(node==null)return;

        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;

        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        for(int i=1;i<list.size();i++){
            if(list.get(i-1)>=list.get(i))return false;
        }
        return true;
    }
}
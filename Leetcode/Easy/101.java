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
    public void preOrderRight(TreeNode node, List<Integer> list){
        if(node==null){
            list.add(-1);
            return;
        }
        list.add(node.val);
        preOrderRight(node.right,list);
        preOrderRight(node.left,list);
    }
    public void preOrderLeft(TreeNode node, List<Integer> list){
        if(node==null){
            list.add(-1);
            return;
        }
        list.add(node.val);
        preOrderLeft(node.left,list);
        preOrderLeft(node.right,list);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        List<Integer> listLeft = new ArrayList<>();
        List<Integer> listRight = new ArrayList<>();
        
        preOrderLeft(root,listLeft);
        preOrderRight(root,listRight);
        
        if(listLeft.size()!=listRight.size())return false;
        
        for(int i=0;i<listLeft.size();i++){
            if(listLeft.get(i)!=listRight.get(i))return false;
        }
        
        return true;
    }
}
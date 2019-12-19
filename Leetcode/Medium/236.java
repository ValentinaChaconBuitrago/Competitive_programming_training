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
    public boolean findPath(TreeNode node, TreeNode goal, ArrayList<TreeNode> path){
        if(node==null)return false;
        path.add(node);
        if(node==goal)return true;
        
        if(node.left!=null && findPath(node.left, goal, path)) return true;
        if(node.right!=null && findPath(node.right,goal,path)) return true;
        
        path.remove(path.size()-1);
        return false;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pathP = new ArrayList<>();
        ArrayList<TreeNode> pathQ = new ArrayList<>();
        
        findPath(root,p,pathP);
        findPath(root,q,pathQ);
        for(int i=0;i<pathP.size();++i){
            System.out.print(pathP.get(i).val + ", ");
        }
        System.out.println();
        for(int i=0;i<pathQ.size();++i){
            System.out.print(pathQ.get(i).val + ", ");
        }
        
        TreeNode ans = pathP.get(0);
        for(int i=1;i<Math.min(pathP.size(),pathQ.size());++i){
            if(pathP.get(i) == pathQ.get(i)) ans = pathP.get(i);
        }
        return ans;
    }
}
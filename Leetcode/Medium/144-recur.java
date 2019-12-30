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
    public void traversal(TreeNode node, List<Integer> list){
        if(node==null)return;
        list.add(node.val);
        traversal(node.left,list);
        traversal(node.right,list);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traversal(root,ans);
        return ans;
    }
}
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        
        ans.add(new ArrayList<>());
        ans.get(0).add(root.val);
        
        HashMap<TreeNode,Integer> level =  new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        level.put(root,0);
        
        while(queue.size()>0){
            TreeNode current = queue.poll();
            //Initialize new level list
            if(ans.size() <= level.get(current) + 1)
                ans.add(new ArrayList<>());
            
            //Add left Node
            if(current.left!=null){
                queue.add(current.left);
                level.put(current.left,level.get(current) + 1);
                ans.get(level.get(current.left)).add(current.left.val);
            }
            //Add right Node
            if(current.right!=null){
                queue.add(current.right);
                level.put(current.right,level.get(current) + 1);
                ans.get(level.get(current.right)).add(current.right.val);
            }
        }
        if(ans.size()>1)ans.remove(ans.size()-1);
        
        return ans;
        
    }
}
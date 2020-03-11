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
    public int maxLevelSum(TreeNode root) {
        if(root==null)return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        int maxTotal = 0;
        int minLevel = 0;

        while(!queue.isEmpty()){
            int numNodes = queue.size();

            int total = 0;
            for(int i=0;i<numNodes;i++){
                TreeNode current = queue.poll();
                total+=current.val;

                if(current.left!=null)queue.add(current.left);
                if(current.right!=null)queue.add(current.right);
            }

            if(total>maxTotal){
                maxTotal=total;
                minLevel=level;
            }
            level++;
        }
        return minLevel;
    }
}
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> nodes = new ArrayList<>();
        if(root==null) return nodes;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int numNodes = queue.size();
            List<Integer> levelNodes = new ArrayList<>();

            for(int i=0;i<numNodes;i++){
                TreeNode current = queue.poll();
                levelNodes.add(current.val);

                if(current.left!=null)queue.add(current.left);
                if(current.right!=null)queue.add(current.right);
            }
            nodes.add(levelNodes);
        }
        return nodes;
    }
}
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return null;

        List<TreeNode> tree = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //Step 1: get all nodes in level order backwards
        while(!queue.isEmpty()){
            int numNodes = queue.size();
            for(int i=0;i<numNodes;i++){
                TreeNode current = queue.poll();
                tree.add(current);
                if(current==null) continue;
                queue.add(current.right);
                queue.add(current.left);
            }
        }

        //Step 2: build the tree in the right order
        queue.add(root);
        int i=1;
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(i<tree.size() && tree.get(i)!=null){
                TreeNode left = tree.get(i);
                current.left=left;
                queue.add(left);
            }else current.left=null;
            i++;
            if(i<tree.size() && tree.get(i)!=null){
                TreeNode right = tree.get(i);
                current.right=right;
                queue.add(right);
            }else current.right=null;
            i++;
        }

        return root;
    }
}
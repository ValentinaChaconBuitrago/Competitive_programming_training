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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> temp = new ArrayList<>();

        if(root==null)return temp;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        HashMap<TreeNode, Integer> level = new HashMap<>();
        level.put(root,0);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            int currentLevel = level.get(current);

            //determine whether or not to create a new list
            if(temp.size()==currentLevel){
                List<Integer> list = new ArrayList<>();
                temp.add(list);
            }
            temp.get(currentLevel).add(current.val);

            if(current.left!=null){
                queue.add(current.left);
                level.put(current.left,currentLevel+1);
            }
            if(current.right!=null){
                queue.add(current.right);
                level.put(current.right,currentLevel+1);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=temp.size()-1;i>=0;i--){
            ans.add(temp.get(i));
        }
        return ans;
    }
}
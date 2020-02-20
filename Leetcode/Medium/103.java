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
    public boolean isLeaf(TreeNode node){
        if(node.left==null && node.right==null) return true;
        return false;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;

        HashMap<TreeNode,Integer> level = new HashMap<>();
        level.put(root,0);

        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        list.add(first);

        System.out.println(leftToRight);

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            int currentLevel = level.get(current);

            if(list.size()==currentLevel+1 && !isLeaf(current)){
                list.add(new ArrayList<>());
            }


            if(current.left!=null){
                queue.add(current.left);
                level.put(current.left,currentLevel+1);
                list.get(level.get(current.left)).add(current.left.val);
            }
            if(current.right!=null){
                queue.add(current.right);
                level.put(current.right,currentLevel+1);
                list.get(level.get(current.right)).add(current.right.val);
            }
        }
        for(int i=0;i<list.size();i++){
            if(i%2==1)Collections.reverse(list.get(i));
        }
        return list;
    }
}
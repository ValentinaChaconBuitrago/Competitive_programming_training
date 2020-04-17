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
    private int maxDiameter;

    public int distance(TreeNode node){
        //Base case
        if(node==null) return 0;

        int distanceLeft = distance(node.left);
        int distanceRight = distance(node.right);;

        int currentDiameter = distanceLeft + distanceRight;
        maxDiameter = Math.max(maxDiameter, currentDiameter);

        return Math.max(distanceLeft+1,distanceRight+1);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        distance(root);
        return maxDiameter;
    }
}
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
    private static int rootIndex;
    public TreeNode tree(int[] inorder, int[] postorder, int inStrt, int inEnd){
    
        //Base Case
        if(inStrt>inEnd) return null;
          
        //Root creation
        TreeNode node = new TreeNode(postorder[rootIndex]);
        rootIndex--;
        
        //The current node doesn't have any children
        if(inStrt == inEnd) return node;

        //look for the index of root in the inorder array
        int thisNodeIndex = search(inorder,inStrt,inEnd,node.val);
        
        node.right = tree(inorder,postorder,thisNodeIndex+1,inEnd);
        node.left = tree(inorder,postorder,inStrt,thisNodeIndex-1);
        
        return node;
    }
    public int search(int[] inorder, int start, int end, int val){
        int ans = 0;
        for(int i=start;i<=end;i++){
            if(inorder[i]==val){
                ans=i;
                return ans;
            }
        }
        return ans;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        rootIndex = postorder.length-1;
        TreeNode root = tree(inorder,postorder,0,inorder.length-1);
        return root;
    }
}
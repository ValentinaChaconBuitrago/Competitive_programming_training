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
    private int rootNode;
    private HashMap <Integer,Integer> indexInfo;
    
    public TreeNode tree(int[] preorder, int[] inorder, int startIndex, int endIndex){
        if(startIndex>endIndex)return null;
        TreeNode node = new TreeNode(preorder[rootNode]);
        rootNode++;
        
        if(startIndex==endIndex)return node;
        int currentNodeIndex = indexInfo.get(node.val);
        
        node.left = tree(preorder,inorder,startIndex,currentNodeIndex-1);
        node.right = tree(preorder,inorder,currentNodeIndex+1,endIndex);
        
        return node; 
    }
    
    /*This method is used when the hashmap is not implemented. By using it complexity goes from
    O(n) to O(n^2)
    */
    public int search(int[] inorder, int start, int end, int val){
        int ans = -1;
        for(int i=start;i<=end;i++){
            if(inorder[i]==val){
                ans = i;
                break;
            }
        }
        return ans;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Store values and indices of inorder in the hashmap
        indexInfo = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            indexInfo.put(inorder[i],i);
        }
        
        rootNode = 0;
        TreeNode root = tree(preorder,inorder,0,inorder.length-1);
        return root;
    }
}
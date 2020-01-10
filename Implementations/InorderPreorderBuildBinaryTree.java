//Build a BinaryTree from an inorder(left,root,right) and a preorder(root,left,right) traversal
class Solution{
	/*
	Preorder array gives information about the root of the current tree whilst the inorder array
	provides information regarding the contents of the left and right subtree for the given root.
	As for the case of preorder arrays, the root of the tree is given as position 0 and left and
	right subtree's roots follow. 
	*/
	private int rootNode;
	private HashMap<Integer,Integer> indices;

	public TreeNode buildTree(int[] inorder, int[] preorder, int startIndex, int endIndex){
		if(startIndex>endIndex)return null;

		TreeNode node = new TreeNode(preorder[rootNode]);
		rootNode++;

		if(startIndex==endIndex) return node;

		int currentNodeIndex = indices.get(node.val);
		node.left = buildTree(inorder,preorder,startIndex,currentNodeIndex-1);
		node.right = buildTree(inorder,preorder,currentNodeIndex+1,endIndex);

		return node;
	}
	public TreeNode buildDriver(int[] inorder, int[] preorder){
		indices = new HashMap<>();
		for(int i=0;i<inorder.length;i++){
			indices.put(inorder[i],i);
		}

		rootNode = 0;
		TreeNode root = buildTree(inorder,preorder,0,inorder.length-1);
		return root;
	}
}
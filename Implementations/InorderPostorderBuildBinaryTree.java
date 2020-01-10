//Build a BinaryTree from an inorder(left,root,right) and a postorder(left,right,root) traversal
class Solution{
	/*
	start and end index are meant to keep track of positions in the inorder array
	root index keeps track of the root index in a general way
	*/
	private int rootIndex;
	public TreeNode buildTree(int[] inorder,int[] postorder,int startIdex, int endIndex){
		//Base case
		(startIndex>endIndex)return null;

		//Root node 
		TreeNode node = new TreeNode(postorder[rootIndex]);
		rootIndex--;

		if(startIndex==endIndex)return node;

		//Index of the current node in the inorder array
		int currentNodeIndex =  search(inoder,startIndex,endIndex,node.val);

		node.right = buildTree(inorder,postorder,currentNodeIndex+1,endIndex);
		node.left = buildTree(inorder,postorder,startIndex,currentNode-1);

		return node;
	}

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

	public TreeNode buildDriver(int[] inorder, int[] postorder){
		rootIndex = postorder.length - 1;
		TreeNode root = buildTree(inorder, postorder, 0, postoder.length-1);
		return root;
	}
}
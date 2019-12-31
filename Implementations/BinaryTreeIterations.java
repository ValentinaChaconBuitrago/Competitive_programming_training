public List<Integer> preOrderTraversal(TreeNode root){
	
	List<Integer> ans = new ArrayList<>();
	if(root==null)return ans;

	Stack<TreeNode> stack = new Stack<>();
	TreeNode current = root;

	while(current!=null||!stack.empty()){
		while(current!=null){
			ans.add(current.val);
			stack.push(current);
			current = current.left;
		}

		if(!stack.empty()){
			current = stack.pop();
			current = current.right;
		}

	}

	return ans;
}


public List<Integer> inOrderTraversal(TreeNode root){
	
	List<Integer> ans = new ArrayList<>();
	if(root==null)return ans;

	Stack<TreeNode> stack = new Stack<>();
	TreeNode current = root;

	while(current!=null || !stack.empty()){
		while(current!=null){
			stack.push(current);
			current = current.left;
		}
		current = stack.pop();
		ans.add(current.val);
		current = current.right;
	}





	return ans;
}
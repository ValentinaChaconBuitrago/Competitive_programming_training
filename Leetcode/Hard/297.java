/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return " ";

        StringBuilder br = new StringBuilder();
        //BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current==null)br.append("null,");
            else{
                br.append(current.val + ",");

                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return br.toString();
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty() || data == " ") return null;

        String[] tree = data.split(",");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
        queue.add(root);

        for(int i=1;i<tree.length;i++){
            TreeNode current = queue.poll();
            if(!tree[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(tree[i]));
                current.left = left;
                queue.add(left);
            }
            i++;
            if(i<tree.length && !tree[i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(tree[i]));
                current.right = right;
                queue.add(right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
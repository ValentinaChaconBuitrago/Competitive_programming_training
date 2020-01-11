/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root==null)return null;
        List<List<Node>> levels = new ArrayList<>();
        levels.add(new ArrayList<>());
        levels.get(0).add(root);
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        HashMap<Node,Integer> nodes = new HashMap<>();
        nodes.put(root,0);
        
        while(queue.size()>0){
            Node current = queue.poll();
            int lev = nodes.get(current);
            
            //Initialize new level list
            if(levels.size()==lev+1){
                levels.add(new ArrayList<>());
            }
            
            if(current.left!=null){
                queue.add(current.left);
                nodes.put(current.left, lev+1);
                levels.get(lev+1).add(current.left);
            }
            if(current.right!=null){
                queue.add(current.right);
                nodes.put(current.right,lev+1);
                levels.get(lev+1).add(current.right);
            }
        }
        
        if(levels.size()>1)levels.remove(levels.size()-1);
        
        for(int i=0;i<levels.size();i++){
            for(int j=0;j<levels.get(i).size()-1;j++){
                levels.get(i).get(j).next = levels.get(i).get(j+1);
            }
        }
        
        return root;
        
    }
}
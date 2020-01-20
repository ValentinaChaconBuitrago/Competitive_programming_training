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
        if(root==null)return root;
        List<List<Node>> list = new ArrayList<>();
        connectTree(root,0,list);
        return root;
    }
    public void connectTree(Node node, int level, List<List<Node>> list){
        
        if(node==null)return;
        
        //There's a new level added
        if(list.size()==level) list.add(new ArrayList<Node>());
        
        int listSize = list.get(level).size();
        if(listSize>0)list.get(level).get(listSize-1).next = node;
        list.get(level).add(node);
        
        connectTree(node.left,level+1,list);
        connectTree(node.right,level+1,list);
    
    }
}
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
        connectTwo(root.left,root.right);
        return root;
    }
    
    public void connectTwo(Node firstNode, Node secondNode){
        if(firstNode==null && secondNode==null) return;
        
        firstNode.next = secondNode;
        
        connectTwo(firstNode.left,firstNode.right);
        connectTwo(secondNode.left,secondNode.right);
        connectTwo(firstNode.right,secondNode.left);
    }
}
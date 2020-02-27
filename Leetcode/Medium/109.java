/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public void createList(List<Integer> data, ListNode node){
        if(node==null) return;
        data.add(node.val);
        createList(data,node.next);
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> data = new ArrayList<>();
        createList(data, head);
        return buildTree(data, 0, data.size()-1);
    }

    public TreeNode buildTree(List<Integer> data, int left, int right){
        if(right<left)return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(data.get(mid));
            root.left = buildTree(data,left,mid-1);
            root.right = buildTree(data,mid+1,right);
        return root;
    }
}
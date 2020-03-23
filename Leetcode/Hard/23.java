/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode node1, ListNode node2){
        ListNode head = new ListNode(0);
        ListNode current = head;
        while(node1!=null && node2!=null){
            if(node1.val<node2.val){
                current.next = node1;
                node1 = node1.next;
            }else{
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }
        if(node1!=null)current.next = node1;
        if(node2!=null)current.next = node2;

        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        if(lists.length==1)return lists[0];

        ListNode list = lists[0];
        for(int i=1;i<lists.length;i++){
            list = mergeTwoLists(list, lists[i]);
        }
        return list;
    }
}
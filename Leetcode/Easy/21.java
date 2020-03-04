/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)return null;
        if(l1==null)return l2;
        if(l2==null)return l1;

        ListNode base = new ListNode(0);
        ListNode root = base;

        //Case 1: can compare both lists
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                root.next = l1;
                root = root.next;
                l1 = l1.next;
            }
            else{
                root.next = l2;
                root = root.next;
                l2 = l2.next;
            }
        }

        //Case 2: lists have different sizes add remaining elements
        if(l1!=null){
            root.next = l1;
        }

        if(l2!=null){
            root.next = l2;
        }

        return base.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseListIterative(ListNode head) {
        ListNode next = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = next;
            next = head;
            head = temp;
        }
        return next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode root = head;
        int totalNodes = -1;
        while(root!=null){
            totalNodes++;
            root = root.next;
        }

        int num = 0;
        while(head!=null){
            num += ((int)Math.pow(2,totalNodes)*head.val);
            head = head.next;
            totalNodes--;
        }
        return num;
    }
}
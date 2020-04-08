/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int totalNodes = 0;
        ListNode current = head;
        while(current!=null){
            totalNodes++;
            current = current.next;
        }
        int mid = (totalNodes+1)/2;
        if(totalNodes%2==0)mid++;

        System.out.println(mid);

        ListNode middle = head;
        while(mid>1){
            middle=middle.next;
            mid--;
        }

        return middle;
    }
}
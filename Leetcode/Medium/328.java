/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode current = head;

        ListNode even = new ListNode(0);
        ListNode currentEven = even;

        ListNode odd = new ListNode(0);
        ListNode currentOdd = odd;

        int indicator = 1;

        while(current!=null){
            //Case 1: current node is even
            if(indicator%2==0){
                currentEven.next=current;
                currentEven = currentEven.next;
            }
            //Case 2: current node is odd
            if(indicator%2==1){
                currentOdd.next=current;
                currentOdd = currentOdd.next;
            }

            current = current.next;
            indicator++;
        }


        currentOdd.next=null;
        currentEven.next=null;

        currentOdd.next = even.next;
        return odd.next;

    }
}
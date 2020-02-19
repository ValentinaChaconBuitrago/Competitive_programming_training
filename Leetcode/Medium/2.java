/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Dummy node that stores values
        ListNode ans = new ListNode(-1);
        ListNode current = ans;
        int carry = 0;
        while(l1!= null || l2!= null){
            int x = carry;
            if(l1!=null){
                x+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                x+=l2.val;
                l2 = l2.next;
            }

            int digit = x%10;
            carry = x/10;
            ListNode sum = new ListNode(digit);
            current.next = sum;
            current = sum;
        }

        if(carry==1){
            ListNode node = new ListNode(1);
            current.next = node;
        }
        return ans.next;
    }
}
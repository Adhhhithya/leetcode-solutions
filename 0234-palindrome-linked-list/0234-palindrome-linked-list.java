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
    private static ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
       if(head==null || head.next==null){
        return true;
       }
       ListNode fast = head;
       ListNode slow = head;

       while(fast.next!=null && fast.next.next!=null){
        fast = fast.next.next;
        slow = slow.next;
       }

       ListNode newHead = reverse(slow.next);

       ListNode first = head;
       ListNode second = newHead;

       while(second!=null){
        if(first.val!=second.val){
            newHead = reverse(newHead);
            return false;
        }
        first = first.next;
        second = second.next;
       }
       newHead = reverse(newHead);
       return true;
    }
}
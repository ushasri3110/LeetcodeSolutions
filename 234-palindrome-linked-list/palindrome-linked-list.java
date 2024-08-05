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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode reversed=reverse(slow.next);
        while (head!=null && reversed!=null){
            if (head.val!=reversed.val){
                return false;
            }
            head=head.next;
            reversed=reversed.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode current=head;
        ListNode prev=null;
        ListNode nextNode=null;
        while (current!=null){
            nextNode=current.next;
            current.next=prev;
            prev=current;
            current=nextNode;
        }
        head=prev;
        return head;
    }
}
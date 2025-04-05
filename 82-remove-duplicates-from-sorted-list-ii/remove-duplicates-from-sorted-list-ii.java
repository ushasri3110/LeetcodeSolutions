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
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode result=new ListNode(0,head);
        ListNode prev=result;
        ListNode current=head;
        while (current!=null){
            while (current.next!=null && current.val==current.next.val){
                current=current.next;
            }
            if (prev.next!=current){
                prev.next=current.next;
            }
            else{
                prev=prev.next;
            }
            current=current.next;
        }
        return result.next;
    }
}
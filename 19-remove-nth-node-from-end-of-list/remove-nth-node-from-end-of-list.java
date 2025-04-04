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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res=new ListNode(0,head);
        ListNode temp=res;
        int i=0;
        while (i<n){
            head=head.next;
            i++;
        }
        while (head!=null){
            head=head.next;
            temp=temp.next;
        }
       temp.next=temp.next.next;
       return res.next;
    }
}
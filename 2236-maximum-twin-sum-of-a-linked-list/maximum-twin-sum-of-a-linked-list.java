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
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode prev=null;
        ListNode nextNode=null;
        while (slow!=null){
            nextNode=slow.next;
            slow.next=prev;
            prev=slow;
            slow=nextNode;
        }
        int sum=0;
        while(prev!=null){
            sum=Math.max(sum,head.val+prev.val);
            head=head.next;
            prev=prev.next;
        }
        return sum;
    }
}
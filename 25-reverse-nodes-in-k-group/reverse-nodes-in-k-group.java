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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null||k==1){
            return head;
        }
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return reverseKGroupHelper(head,k,count);
    }
    public ListNode reverseKGroupHelper(ListNode head,int k,int remainingNodes){
        if (remainingNodes<k){
            return head;
        }
        ListNode prev=null;
        ListNode current=head;
        ListNode next=null;
        for (int i=0;i<k;i++){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        if (next!=null){
            head.next=reverseKGroupHelper(next,k,remainingNodes-k);
        }
        return prev;
    }
}
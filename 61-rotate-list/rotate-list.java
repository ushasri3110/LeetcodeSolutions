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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int n=1;
        ListNode tail=head;
        while (tail.next!=null){
            tail=tail.next;
            n++;
        }
        tail.next=head;
        k=k%n;
        int stepsToNewTail=n-k;
        ListNode newTail=head;
        for (int i=0;i<stepsToNewTail-1;i++){
            newTail=newTail.next;
        }
        ListNode newHead=newTail.next;
        newTail.next=null;
        return newHead;
    }
}
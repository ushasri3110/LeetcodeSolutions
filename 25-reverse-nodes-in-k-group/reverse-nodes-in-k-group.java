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
    // private ListNode findKth(ListNode head,int k){
    //     ListNode current=head;
    //     while (current!=null && k>0){
    //         k--;
    //         current=current.next;
    //     }
    //     return current;
    // }
    // public ListNode reverseKGroup(ListNode head, int k) {
    //     if (head==null || k==1) return head;
    //     ListNode dummy=new ListNode(0);
    //     dummy.next=head;
    //     ListNode prevGroupEnd=dummy;
    //     while (true){
    //         ListNode kth=findKth(prevGroupEnd,k);
    //         if (kth==null) break;
    //         ListNode groupStart=prevGroupEnd.next;
    //         ListNode nextGroupStart=kth.next;
    //         ListNode current=groupStart,prev=nextGroupStart,next;
    //         while (current!=nextGroupStart){
    //             next=current.next;
    //             current.next=prev;
    //             prev=current;
    //             current=next;
    //         }
    //         prevGroupEnd.next=kth;
    //         prevGroupEnd=groupStart;
    //     }
    //     return dummy.next;
    // }
    private ListNode findKth(ListNode head,int k){
        ListNode temp=head;
        while (temp!=null && k>0){
            temp=temp.next;
            k--;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k){
        if (head==null || k==1) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prevGroupEnd=dummy;
        while (true){
            ListNode groupStart=prevGroupEnd.next;
            ListNode kth=findKth(prevGroupEnd,k);
            if (kth==null) break;
            ListNode nextGroupStart=kth.next;
            ListNode current=groupStart;
            ListNode prev=nextGroupStart;
            while (current!=nextGroupStart){
                ListNode next=current.next;
                current.next=prev;
                prev=current;
                current=next;
            }
            prevGroupEnd.next=kth;
            prevGroupEnd=groupStart;
        }
        return dummy.next;
    }

}
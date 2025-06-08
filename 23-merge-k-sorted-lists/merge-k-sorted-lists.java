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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int k=lists.length;
        int interval=1;
        while (interval<k){
            for (int i=0;i+interval<k;i+=interval*2){
                lists[i]=merge(lists[i],lists[i+interval]);
            }
            interval*=2;
        }
        return lists[0];
    }
    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while (l1!=null && l2!=null){
            if (l1.val<=l2.val){
                tail.next=l1;
                l1=l1.next;
            }
            else{
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }
        tail.next=(l1!=null)?l1:l2;
        return dummy.next;
    }
}
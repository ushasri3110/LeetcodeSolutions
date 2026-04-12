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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1=l1;
        ListNode h2=l2;
        ListNode res=new ListNode(0);
        ListNode temp=res;
        int carry=0;
        while (h1!=null || h2!=null || carry!=0){
            int sum=carry;
            if (h1!=null){
                sum+=h1.val;
                h1=h1.next;
            }
            if (h2!=null){
                sum+=h2.val;
                h2=h2.next;
            }
            int digit=sum%10;
            ListNode newNode=new ListNode(digit);
            temp.next=newNode;
            temp=newNode;
            carry=sum/10;
        }
        return res.next;
    }
}
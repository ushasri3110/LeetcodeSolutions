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
        ListNode res=new ListNode(0);
        int carry=0;
        ListNode temp=res;
        while (carry!=0 || l1!=null || l2!=null){
            int sum=carry;
            if (l1!=null){
                sum=sum+l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                sum=sum+l2.val;
                l2=l2.next;
            }
            int num=sum%10;
            ListNode newNode=new ListNode(num);
            temp.next=newNode;
            temp=newNode;
            carry=sum/10;
        }
        return res.next;
    }
}
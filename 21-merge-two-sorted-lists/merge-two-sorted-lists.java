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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res=new ListNode(0);
        ListNode temp=res;
        while (list1!=null && list2!=null){
            if (list1.val<list2.val){
                ListNode newNode=new ListNode(list1.val);
                temp.next=newNode;
                list1=list1.next;
            }
            else{
                ListNode newNode=new ListNode(list2.val);
                temp.next=newNode;
                list2=list2.next;
            }
            temp=temp.next;
        }
        while (list1!=null){
            ListNode newNode=new ListNode(list1.val);
            temp.next=newNode;
            list1=list1.next;
            temp=temp.next;
        }
        while (list2!=null){
            ListNode newNode=new ListNode(list2.val);
            temp.next=newNode;
            list2=list2.next;
            temp=temp.next;
        }
        return res.next;
    }
}
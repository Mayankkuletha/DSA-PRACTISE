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
    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public ListNode mergeList(ListNode leftHead,ListNode rightHead){

        ListNode t1 = leftHead;
        ListNode t2 = rightHead;

        ListNode dummy = new ListNode (-1);
        ListNode temp = dummy;

        while(t1!=null && t2!=null){

            if(t1.val <= t2.val){
                temp.next=t1;
                t1=t1.next;
            }else{
                temp.next=t2;
                t2=t2.next;
            }
            temp = temp.next;
        }
        if(t1==null){
            temp.next=t2;
        }else{
            temp.next=t1;
        }
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        //single or no element
        if(head==null || head.next==null){
            return head;
        }
    
       ListNode middle = middle(head);
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next=null;

        leftHead= sortList(leftHead);
        rightHead=sortList(rightHead);

        return mergeList(leftHead,rightHead);



    }
}
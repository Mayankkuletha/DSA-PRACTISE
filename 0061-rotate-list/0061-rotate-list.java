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
    public ListNode findLast(ListNode head , int k){
        ListNode temp = head;
        for(int i = 1 ; i<k;i++){
            temp= temp.next;
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null  || head.next==null || k==0) return head;
        ListNode temp = head;
        ListNode tail = head;
        int len = 1;
        while(temp.next!=null){
            temp=temp.next;
            len++;
        }
        tail=temp;
        if(k%len==0) return head;
        tail.next=head;
        k = k%len;
        ListNode lastNode = findLast(head , len-k);
        ListNode nextNode = lastNode.next;
        head = nextNode;
        lastNode.next = null;
        return head;
    }
}
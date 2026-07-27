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

    public ListNode reverseLL(ListNode temp){

        ListNode prev = null;
        ListNode curr = temp;

        while(curr != null){
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        return prev;
    }

    public ListNode findKthNode(ListNode temp, int k){

        k--;

        while(temp != null && k > 0){
            temp = temp.next;
            k--;
        }

        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){

            ListNode kNode = findKthNode(temp, k);

            if(kNode == null){

                if(prev != null){
                    prev.next = temp;
                }

                break;
            }

            ListNode nextNode = kNode.next;

            kNode.next = null;

            ListNode newHead = reverseLL(temp);

            if(temp == head){
                head = newHead;
            }
            else{
                prev.next = newHead;
            }

            prev = temp;
            temp = nextNode;
        }

        return head;
    }
}
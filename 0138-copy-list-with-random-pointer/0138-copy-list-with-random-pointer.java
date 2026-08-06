/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        // Step 1: Insert copy nodes in between
        Node temp = head;

        while (temp != null) {

            Node copy = new Node(temp.val);

            copy.next = temp.next;
            temp.next = copy;

            temp = copy.next;
        }

        // Step 2: Connect random pointers
        temp = head;

        while (temp != null) {

           Node copy = temp.next;

         if (temp.random != null) {
           copy.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Step 3: Separate the two lists
        Node dummy = new Node(-1);
        Node res = dummy;

        temp = head;

        while (temp != null) {

            res.next = temp.next;      // attach copied node
            res = res.next;            // move in copied list

            temp.next = temp.next.next; // restore original list
            temp = temp.next;           // move to next original node
        }

        return dummy.next;
    }
}
class BrowserHistory {
    
    class ListNode{
        String data;
        ListNode back;
        ListNode forward;
        ListNode(String data){
            this.data = data;
        }
    }
    ListNode curr;

    public BrowserHistory(String homepage) {
        curr = new ListNode(homepage);
    }

    public void visit(String url) {

        ListNode newNode = new ListNode(url);

        curr.forward = newNode;
        newNode.back = curr;

        curr = newNode;
    }

    public String back(int steps) {

        while (steps > 0) {

            if (curr.back != null) {
                curr = curr.back;
                steps--;
            } else {
                break;
            }
        }

        return curr.data;
    }

    public String forward(int steps) {

        while (steps > 0) {

            if (curr.forward != null) {
                curr = curr.forward;
                steps--;
            } else {
                break;
            }
        }

        return curr.data;
    }
}
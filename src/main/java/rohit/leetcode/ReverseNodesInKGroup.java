package rohit.leetcode;

public class ReverseNodesInKGroup {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;

        //reach K+1
        while(current != null && count != k){
            current = current.next;
            count++;
        }

        if(count == k){ //reached K+1 node even if the node is null its fine as we are using recursion
            current = reverseKGroup(current,k); //reverse using recursion the remain part

            //reverse the current set
            while(count-- > 0){
                ListNode temp =  head.next;
                head.next = current;
                current = head;
                head = temp;
            }

            head = current;
        }

        return head;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ReverseNodesInKGroup.ListNode listNode1 = reverseNodesInKGroup.new ListNode();
        listNode1.val=1;
        ReverseNodesInKGroup.ListNode listNode2 = reverseNodesInKGroup.new ListNode();
        listNode2.val=1;
        listNode1.next = listNode2;

        reverseNodesInKGroup.reverseKGroup(listNode1,2);
    }

}

package rohit.leetcode;

public class MergeKSortedLists {
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists,0);
    }

    private ListNode mergeKLists(ListNode[] lists, int i) {
        if(i == lists.length - 1){
            return lists[i];
        }else{
            ListNode forward = mergeKLists(lists,i + 1);
            ListNode current = lists[i];
            ListNode dummyHead = new ListNode();
            ListNode move = dummyHead;
            while(forward != null && current != null){
                if(forward.val < current.val){
                    move.next = forward;
                    forward = forward.next;
                    move = move.next;
                }else{
                    move.next = current;
                    current = current.next;
                    move = move.next;
                }
            }
            while (current!=null){
                move.next = current;
                current = current.next;
                move = move.next;
            }
            while (forward!=null){
                move.next = forward;
                forward = forward.next;
                move = move.next;
            }

            return dummyHead.next;
        }

    }
}

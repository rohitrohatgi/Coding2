package rohit.leetcode;

/**
 * Created by rohit on 16/6/20.
 */
public class AddTwoNumbersSolution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode result = new ListNode();
            int carry = 0;

            ListNode current = result;

            while (l1 != null || l2 != null) {
                int x = l1 == null ? 0 : l1.val;
                int y = l2 == null ? 0 : l2.val;
                current.next = new ListNode();
                int sum = x + y + carry;
                carry = sum / 10;
                current.next.val = sum % 10;
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
                current = current.next;

            }
            if (carry > 0) {
                current.next = new ListNode(carry);
            }

            return result.next;
    }



}

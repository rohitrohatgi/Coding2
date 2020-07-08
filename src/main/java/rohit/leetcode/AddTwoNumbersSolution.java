package rohit.leetcode;

/**
 * Created by rohit on 16/6/20.
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
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

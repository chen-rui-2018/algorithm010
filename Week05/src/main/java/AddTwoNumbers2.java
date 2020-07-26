/**
 * @author： chenr
 * @date： Created on 2020/7/9 10:49
 * @version： v1.0
 * @modified By:
 * 两数相加
 */
public class AddTwoNumbers2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(3);
        ListNode l13 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);

        l1.next = l13;
        l13.next = l12;

        l2.next = l21;
        l21.next = l22;
        ListNode result =   new AddTwoNumbers2().addTwoNumbers(l1,l2);
        System.out.println();
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode front = new ListNode(0);
        ListNode curry = front;
        int curr = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = curr + x + y;
            curr = sum / 10;
            curry.next = new ListNode(sum % 10);
            curry = curry.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (curr > 0) {
            curry.next = new ListNode(curr);
        }
        return front.next;
    }
}

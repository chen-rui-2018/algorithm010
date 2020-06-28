import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author： chenr
 * @date： Created on 2020/6/26 22:21
 * @version： v1.0
 * @modified By:
 *  移除重复节点
 */
public class RemoveDuplicateNodes {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode result =    new RemoveDuplicateNodes().removeDuplicateNodes(listNode1);
        while (result != null) {
            System.out.print(result.val+",");
            result = result.next;
        }
    }
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> occurred = new HashSet<Integer>();
        occurred.add(head.val);
        ListNode pos = head;
        // 枚举前驱节点
        while (pos.next != null) {
            // 当前待删除节点
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;


    }
}

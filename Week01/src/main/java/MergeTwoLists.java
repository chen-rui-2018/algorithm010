/**
 * @author： chenr
 * @date： Created on 2020/6/14 22:29
 * @version： v1.0
 * @modified By:
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2) ;
        ListNode listNode4 = new ListNode(4) ;
        listNode1.next = listNode2;
        listNode2.next = listNode4;
        ListNode listNodeA1 = new ListNode(1);
        ListNode listNodeA2 = new ListNode(3) ;
        ListNode listNodeA4 = new ListNode(4) ;
        listNodeA1.next = listNodeA2;
        listNodeA2.next = listNodeA4;




       ListNode aim =  mergeTwoLists(listNode1,listNodeA1);
       while (aim.next != null){
           System.out.print(aim.val+"->");
           aim = aim.next;
       }

    }
    public static  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null ){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        else if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else  {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

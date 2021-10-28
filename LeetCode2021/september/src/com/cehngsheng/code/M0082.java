package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/10/12
 */
public class M0082 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode a = head;
        ListNode node = new ListNode();
        node.next=a;
        int t = Integer.MIN_VALUE;
        while (a.next != null) {
            if (a.next.val==a.val) {

            }
        }
        return null;
    }
}

package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author ssqswyf
 * @Date 2021/8/30
 */
public class _0201 {
    public static void main(String[] args) {

    }


    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode pos = head;
        set.add(head.val);
        while (pos.next != null) {
            ListNode cur = pos.next;
            if (set.add(cur.val)){
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }


}

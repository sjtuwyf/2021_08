package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/9/10
 */
public class S1290 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {

    }

    public int getDecimalValue(ListNode head) {
        int result =0;
        ListNode curr = head;

        while (curr!=null){
            result = result * 2 + curr.val;
            curr = curr.next;
        }
        return result;
    }
}

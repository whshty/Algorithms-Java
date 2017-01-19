/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if( head == null || head.next == null ) return;
        ListNode slow = head, fast = head;
        while( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode part2 = reverse(slow.next);
        slow.next = null;
        merge(head,part2);
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while( cur != null ){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    private void merge(ListNode l1, ListNode l2){
        if( l1 == null || l2 == null ) return;
        ListNode pre = new ListNode(0);
        ListNode head = pre;
        while ( l1 != null && l2 != null ){
            head.next = l1;
            l1 = l1.next;
            head.next.next = l2;
            l2 = l2.next;
            head = head.next.next;
        }
        head.next =  l1 == null ? l2 : l1; 
    }
}
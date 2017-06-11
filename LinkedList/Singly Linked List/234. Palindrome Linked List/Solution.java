public class Solution {
    public boolean isPalindrome(ListNode head){ 
        ListNode slow = head;
        ListNode fast = head;
        while ( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        if ( fast != null ) slow = slow.next;
        slow = reserve(slow);
        while ( slow != null ){
            if ( slow.val == head.val){
                slow = slow.next;
                head = head.next;
            } else return false;
        }
        return true;
    }
    private ListNode reserve(ListNode head){
        ListNode pre = null;
        while ( head != null ){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
public class Solution {
    ListNode head;
    Random random = new Random();;
    

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode res = head;
        ListNode cur = head;
        int size = 1;
        while( cur != null ){
            if( random.nextInt(size) == 0 ){
                res = cur;
            }
            size++;
            cur = cur.next;
        }
        return res.val;
    }
}
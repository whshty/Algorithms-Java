public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if( head == null ) return null;
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        
        RandomListNode cur = head;
        while( cur != null ){
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        } 
        
        cur = head;
        while( cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
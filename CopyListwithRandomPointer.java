// deep copy : maintain a hashmap <node, node.label>
// time o(n)
// space o(1)
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        // loop 1. copy all the nodes
        RandomListNode node = head;
        while( node != null ){
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        // loop 2. assign next and random pointers
        node = head;
        while( node != null ){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}

// time o(n)
// space o(1)
// iteration 
// associate the orgianl node with its copy node in a single linked list
// don't need extra space to keep tack of  the new nodes

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return head;
        RandomListNode cur = head; 
        // first round : make copy of each node
        // link them tegether side-by-side in a single list 
        while( cur != null){
            RandomListNode next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        // second round : assign random pointers for the copy nodes 
        cur = head;
        while( cur != null ){
            if( cur.random != null ) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // restore the original list, and extrac the copy list
        cur = head;
        RandomListNode copyHead = head.next;
        RandomListNode copy = copyHead;
        while(copy.next !=null ){
            cur.next = cur.next.next;
            cur = cur.next;
            
            copy.next = copy.next.next;
            copy = copy.next;
        }
        //cur.next = null;
        cur.next = cur.next.next;
        
        return copyHead;
    }
}
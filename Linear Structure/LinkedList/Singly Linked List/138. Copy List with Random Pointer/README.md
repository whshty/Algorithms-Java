## 1.HashMap to Save Node
* Time : O(n) + Space : O(n)

```
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
```

## 2.Copy Node + Assign Random Pointer + Restore List

```java

class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode node = head, next;
        // First round: make copy Node of each node,
        // and link them together side-by-side in a single list.
        while (node != null) {
            next = node.next;
            RandomListNode newNode = new RandomListNode(node.label);
            node.next = newNode;
            newNode.next = next;
            node = next;
        }

        // Second round: assign random pointers for the copy Node nodes.
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        // Third round: restore the original list, and extract the copy Node list.
        node = head;
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode cur, pre = dummy;

        while (node != null) {
            next = node.next.next;
            cur = node.next;
            pre.next = cur;
            pre = cur;
            // restore the original list
            node.next = next;
            node = next;
        }
        return dummy.next;
    }
}

```
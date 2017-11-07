## 1.Recursion Print
```java
class Solution {
    public void reversePrintInRecursion(ListNode head) {
        if (head == null) return;
        reversePrintInRecursion(head.next);
        System.out.print(head.val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
```

## 2.Stack Print

```java
class Solution {
    public void reversePrintByStack(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
```


## 3.Divide and Conquer Print 

```java
class Solution {
    public void printByDivide(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        helper(head, len);
    }

    private void helper(ListNode head, int length) {
        if (head == null) return;

        if (length == 1) {
            System.out.print(head.val);
            return;
        }

        int count = 0;
        ListNode cur = head;
        while (count < length / 2) {
            cur = cur.next;
            count++;
        }
        helper(cur, length - length / 2);
        helper(head, length / 2);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
```

```
class myCode {
    public void reversePrint(ListNode head) {
        if(head == null) return;
        reversePrint(head.next);
        System.out.print(head.val);
    }
}
```
```java
class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        while( cur != null ){
            TreeLinkNode temp = cur;
            while( temp != null ){
                if( temp.left != null ) temp.left.next = temp.right;
                if( temp.right != null && temp.next != null ) temp.right.next = temp.next.left;
                temp = temp.next;
            }
            cur = cur.left;
        }
    }
}
```
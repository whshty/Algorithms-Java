Here int[] works like a wrap. When you pass (int[])arr to a method, it creates a new reference point to the same object as arr and pass the new reference to the method. Hence when you change for example arr[0] in the method call, since both of the references point to the same object, it will reflect on arr in the parent call;
int is a primitive type, you pass a int variable to a method it simply makes a copy of the variable and pass it to the method.

For example:

```java
void parentMethod() {
  int a = 0;
  int[] arr = new int[1];
  childMethod1(a, arr);
  System.out.print(a); //it will print 0;
  System.out.print(arr[0]); //it will print 1;
}

void childMethod(int a, int[] arr) {
  a++;
  arr[0]++;
}

```

```java
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root,count);
        return count[0];
    }

    public boolean helper(TreeNode node, int[] count){
        if( node == null ) return true;
        boolean left = helper(node.left,count);
        boolean right = helper(node.right,count);

        if( left && right ){
            if( node.left != null && node.val != node.left.val ){
                return false;
            }
            if( node.right != null && node.val != node.right.val ){
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}
```

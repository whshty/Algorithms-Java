### Brute force 
```java
public class Solution {
    public int countNodes(TreeNode root) {
        if( root == null ) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
```


### Explanation
The height of a tree can be found by just going left. Let a single node tree have height 0. Find the height h of the whole tree. If the whole tree is empty, i.e., has height -1, there are 0 nodes.

Otherwise check whether the height of the right subtree is just one less than that of the whole tree, meaning left and right subtree have the same height.

* If yes, then the last node on the last tree row is in the right subtree and the left subtree is a full tree of height h-1. So we take the 2^h-1 nodes of the left subtree plus the 1 root node plus recursively the number of nodes in the right subtree.
* If no, then the last node on the last tree row is in the left subtree and the right subtree is a full tree of height h-2. So we take the 2^(h-1)-1 nodes of the right subtree plus the 1 root node plus recursively the number of nodes in the left subtree.

![alt text](https://github.com/RagingPsyduck/Data-Structures-and-Algorithms-in-Java/blob/master/Binary%20Tree/Top-Down%26Bottom-Up/222.%20Count%20Complete%20Tree%20Nodes/CompleteBinary.jpg)


```java
// Recursion 1
public class Solution {
    public int countNodes(TreeNode root) {
        if( root == null ) return 0;
        int left = countLeftHeight(root);
        int right = countRightHeight(root);
        if( left == right ){
            return (1 << left) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    public int countLeftHeight(TreeNode root){
        if( root == null) return 0;
        return 1 + countLeftHeight(root.left);
    }
    public int countRightHeight(TreeNode root){
        if( root == null) return 0;
        return 1 + countRightHeight(root.right);
    }
}

// Recursion 2
public class Solution {
    public int countNodes(TreeNode root) {
        int treeHeight = countHeight(root);
        if( treeHeight < 0 ) return 0;
        if( countHeight(root.right) == treeHeight-1 ) {
            return (1 << treeHeight) + countNodes(root.right);
        }
        else return countNodes(root.left) + (1 << treeHeight-1);
    }
    public int countHeight(TreeNode root){
        if( root == null) return -1;
        return 1 + countHeight(root.left);
    }
}
```
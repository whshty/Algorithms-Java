# Binary Tree

## Structure
Binary Tree provided a mehod from binary operation to binary structure
* Linear Search : O(n)
* Binary Search : O(nlogn)

```
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
```

## Key Pointers
* Iteration : Maintain a scanner in the tree using a value or stack 
* Recursion : Is recommended, using recursion stack 


## Tips
* Binary Search : traversal is not necessary, so we can also use iteration
* Travesal by level : we can use queue
* Tree and other Data struture (int[],String) : we can use top-down and bottom-up 
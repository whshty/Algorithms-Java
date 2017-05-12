# 105. Construct Binary Tree from Preorder and Inorder Traversal
## Recursion
### Idea
* Pick the first element from preorder as the root
* Deterime the subtree by this root and inorder elements
* Build left and right subtrees and recursion

### Time
* O(n^2)
* Worst case occurs when tree is left or right skewed
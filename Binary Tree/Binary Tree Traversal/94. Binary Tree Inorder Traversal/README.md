# 94. Binary Tree Inorder Traversal
## Stack
### Idea 
* Left, Root, Right
* Depth first to the left to store every node is a stack
* The very first node is our start node
* Check node's right first, the node maybe the root for other nodes
* If the right is null, we can go to the parent node( stack pop)
* If the right is not null, we need to store the right node in stack and travel to next very left

### Time & Space 
* O(n)
* O(n)

## Recursion
### Idea
* DFS
* If the current very left node has right child node, we need to consider it as parent node and go the right subtree

### Time & Space
* o(n)
* o(n) + o(h)
* o(h) is stack space, o(h) = o(logn) is the tree is balanced
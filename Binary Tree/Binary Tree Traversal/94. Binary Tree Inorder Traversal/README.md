# 94. Binary Tree Inorder Traversal
## Idea (Stack)
* Left, Root, Right
* Depth first to the left to store every node is a stack
* The very first node is our start node
* Check node's right first, the node maybe the root for other nodes
* If the right is null, we can go to the parent node( stack pop)
* If the right is not null, we need to store the right node in stack and travel to next very left
* Use a flag to mark the finish status 


## Time & Space 
* O(n)
* O(n)
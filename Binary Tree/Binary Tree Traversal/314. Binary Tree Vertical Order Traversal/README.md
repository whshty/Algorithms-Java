# 314. Binary Tree Vertical Order Traversal
### Idea 
* Use a HashMap to store column value and related result list
* Use a HashMap to store the TreeNode and the according cloumn value
* Map's key is column, we assume the root column is zero, the left node will minus 1 ,and the right node will plus 1


### Time & Space 
* o(n)
* o(n)
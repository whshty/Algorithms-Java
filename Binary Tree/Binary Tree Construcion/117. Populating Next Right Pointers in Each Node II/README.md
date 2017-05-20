# 117. Populating Next Right Pointers in Each Node II
### Idea
* Move all nodes in level order
* Use dummy to track all start node of next level
* Two while loop, the first is for differetn levels, the second is for traversal in the same level

### Time & Space
* o(n)
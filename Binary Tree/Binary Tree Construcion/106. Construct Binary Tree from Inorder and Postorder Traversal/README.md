# 106. Construct Binary Tree from Inorder and Postorder Traversal
## Recursion
### Idea
* Find the last node in postorder[], in our case, it's 1
* Search 1 in inorder[] to find the left and right subtrees of root 1
* Recur the above process for following two

### Time & Space
* o(n^2)

### Visualization

```
Input : 
in[]   = {4, 8, 2, 5, 1, 6, 3, 7}
post[] = {8, 4, 5, 2, 6, 7, 3, 1} 


                1
     [4,8,2,5]       [6,3,7]  

```
![](https://github.com/RagingPsyduck/Data-Structures-and-Algorithms-in-Java/blob/master/Binary%20Tree/Binary%20Tree%20Construcion/106.%20Construct%20Binary%20Tree%20from%20Inorder%20and%20Postorder%20Traversal/Picture/demo.png)
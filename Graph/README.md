### Representations
###### Edge lists
![alt text](https://github.com/RagingPsyduck/Data-Structures-and-Algorithms-in-Java/blob/master/Graph/Pictures/edgelists.png "Logo Title Text 1")

```
[ [0,1], [0,6], [0,8], [1,4], [1,6], [1,9], [2,4], [2,6], [3,4], [3,5],
[3,8], [4,5], [4,9], [7,8], [7,9] ]
```
* Advantages 

  1. Good for dynammic adding
  2. Save space
  
* Disadvantages

  1. Not good for finding connection between i and j
  2. Not good for treversal

###### Adjacency matrices
![alt text](https://github.com/RagingPsyduck/Data-Structures-and-Algorithms-in-Java/blob/master/Graph/Pictures/adjacencymatrices.png "Logo Title Text 1")

* Advantages 

  1. Good for searching connections between two points : O(1)
  2. Good for traveral all nodes

* Disadvantages

  1. Waste of space 	
  
  
###### Adjacency lists
![alt text](https://github.com/RagingPsyduck/Data-Structures-and-Algorithms-in-Java/blob/master/Graph/Pictures/adjacencylist.png "Logo Title Text 1")

* Advantages
  1. Very flexiable for representing the graph, For example, HashMap, List<List<>>, List<Set<>>, List<>[]
  2. Finding is O(1), traversal is O(E) 
  
* Disadvantages 
  1. In the medium of Edges lists and Adjacency matrices

  
### Time and Space
* If you just care about connectivity, instead of path info, Union Find is better 

|       | DFS                   | BFS    | Union Find |
|-------|-----------------------|--------|------------|
| Time  | O(E+V)                | O(E+V) | O(V*h)     |
| Space | O(E+V)                | O(E+V) | O(V)       |
|       | O(V)                  |        |            |
|       | Recursion Stack :O(h) |        |            |

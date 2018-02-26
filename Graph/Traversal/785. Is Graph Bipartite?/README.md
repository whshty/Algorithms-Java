### BFS + Color Array
```java
class Solution {
    public boolean isBipartite(int[][] graph) {
        if ( graph == null || graph.length == 0 ) return true;
        
        int[] color = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for( int i = 0 ; i < graph.length ; i++ ){
            if( color[i] == 0 ) {
                queue.add(i);
                color[i] = 1;
                while( queue.size() != 0 ) {
                    int node = queue.remove();
                    for( int temp : graph[node]){
                        if( color[temp] == 0 ){
                            color[temp] = color[node] == 2 ? 1 : 2;
                            queue.add(temp);    
                        } 
                        else if ( color[temp] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
```


### DFS

```java
// didn't check :0
// color 1 : 1
// color 2 : 2
class Solution {
    public boolean isBipartite(int[][] graph) {
        if ( graph == null || graph.length == 0 ) return true;
        int[] color = new int[graph.length];
        
        for( int i = 0 ; i < graph.length ; i++ ){
            if( color[i] == 0 && !isValid(graph,color,i,1)){
                return false;
            } 
        }
        return true;
    }
    
    public boolean isValid(int[][] graph, int[] color, int index, int val){
        if( color[index] != 0 ) {
            return color[index] == val;
        }
        color[index] = val;
        int nextVal = val == 1 ? 2 : 1;
        for( int node : graph[index] ){
            if(!isValid(graph,color,node,nextVal)) return false;
        }
        return true;
    }
}
```
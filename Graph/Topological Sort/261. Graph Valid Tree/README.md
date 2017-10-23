### BFS
* Node 0 is the root
* Keep on adding nodes to a set, if the nodes is already added, there is a cycle

```java
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if( n < 1 ) return false;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for( int i = 0 ; i < n ; i++ ) {
            map.put(i,new HashSet<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            if( set.contains(node)) return false;
            for( int temp : map.get(node)){
                queue.add(temp);
                map.get(temp).remove(node);
            }
            set.add(node);
        }
        return set.size() == n;
    }
}
```

### DFS

```
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if( n < 1 ) return false;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for( int i = 0 ; i < n ; i++ ) map.put(i,new HashSet<>());
        for(int[] edge : edges ){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }    
        Set<Integer> set = new HashSet<>();
        set.add(0);
        boolean res = hasCycle(map,set,0,-1);
        if(!res) return false;
        return set.size() == n;
    }
    
    private boolean hasCycle( Map<Integer,Set<Integer>> map, Set<Integer> set , int cur, int parent){
        Set<Integer> list= map.get(cur);
        
        for( int i : list){
            if( i == parent ) continue;
            if( set.contains(i) ) return false;
            set.add(i);
            boolean res = hasCycle(map,set,i,cur);
            if( !res ) return false;
        }
        return true;
    }
}

```
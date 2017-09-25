### BFS
```
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
            int entry = queue.remove();
            if( set.contains(entry)) return false;
            for( int node : map.get(entry)){
                queue.add(node);
                map.get(node).remove(entry);
            }
            set.add(entry);
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
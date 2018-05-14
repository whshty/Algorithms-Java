## 1.DFs

```java
public class Solution {
    public int countComponents(int n, int[][] edges) {
        int res = 0;
        Map<Integer,List<Integer>> map = new HashMap<>();        
        for (int i = 0 ; i < n ; i++) map.put(i, new ArrayList<>());
        for (int[] edge : edges){            
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);    
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.add(i)) {
                dfs(i, map, set);
                res++;
            }
        }
        return res;
    }
    
    private void dfs(int cur, Map<Integer, List<Integer>> map, Set<Integer> set) {
        for (int i : map.get(cur)) {
            if (set.add(i)) dfs(i, map, set);    
        }
    }
}
```

## BFS

```java
class Solution {
    public int countComponents(int n, int[][] edges) {
        int res = 0;
        Map<Integer,List<Integer>> map = new HashMap<>();        
        for (int i = 0 ; i < n ; i++) map.put(i, new ArrayList<>());
        for (int[] edge : edges){            
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);    
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0 ; i < n ; i++) {
            if (!set.contains(i)){
                res++;
                bfs(map, set, i);
                
            }
        }
        return res;
    }
    
    private void bfs(Map<Integer,List<Integer>> map, Set<Integer> set, int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            set.add(i);
            for (int next : map.get(i)){
                if(!set.contains(next)) queue.add(next);
            }
        }
    }
}
```
## Iteration
```java
class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for(String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], pq -> new PriorityQueue()).add(ticket[1]);
        }
        Deque<String> stack = new ArrayDeque<>();
        String node = "JFK";

        for (int i = 0; i < tickets.length; i++) {
            // invalid path
            while (!map.containsKey(node) || map.get(node).isEmpty()) {
                stack.push(node);
                node = res.remove(res.size() - 1);
            }
            res.add(node);
            node = map.get(node).poll();
        }
        res.add(node);
        if (!stack.isEmpty()) res.add(stack.pop());
        return res;
    }
}
```

## DFS

```java
class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], queue -> new PriorityQueue<>()).add(ticket[1]);
        }
        dfs("JFK", map, res);
        return res;
    }
    private void dfs(String start, Map<String, PriorityQueue<String>> map, LinkedList<String> res) {
        PriorityQueue<String> heap = map.get(start);
        while (heap != null && !heap.isEmpty() ){
            dfs(heap.poll(), map, res);
        }
        res.addFirst(start);
    }
}
```
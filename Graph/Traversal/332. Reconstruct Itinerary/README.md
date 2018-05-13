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
// Iteration
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for(List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), pq -> new PriorityQueue()).add(ticket.get(1));
        }
        Queue<String> queue = new LinkedList<>();
        String node = "JFK";

        for (int i = 0; i < tickets.size(); i++) {
            // invalid path
            while (!map.containsKey(node) || map.get(node).isEmpty()) {
                queue.add(node);
                node = res.remove(res.size() - 1);
            }
            res.add(node);
            node = map.get(node).poll();
        }
        res.add(node);
        if (!queue.isEmpty()) res.add(queue.poll());
        return res;
    }
}
// DFS
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

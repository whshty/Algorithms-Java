class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> path = new LinkedList<>();
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], queue -> new PriorityQueue<>()).add(ticket[1]);
        }
        dfs("JFK", map, path);
        return path;
    }
    private void dfs(String start, Map<String, PriorityQueue<String>> map, LinkedList<String> path) {
        PriorityQueue<String> heap = map.get(start);
        while (heap != null && !heap.isEmpty() ){
            dfs(heap.poll(), map, path);
        }
        path.addFirst(start);
    }
}
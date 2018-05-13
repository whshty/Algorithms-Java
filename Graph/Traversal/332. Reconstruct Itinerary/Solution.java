// Iteration
class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], queue -> new PriorityQueue<>()).add(ticket[1]);
        }
        
        String cur = "JFK";
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < tickets.length ;i++) {
            // Invalid path
            while (!map.containsKey(cur) || map.get(cur).isEmpty()) {
                stack.push(cur);
                cur = res.remove(res.size()-1);
            }
            res.add(cur);
            cur = map.get(cur).poll();
        }
        res.add(cur);
        while(!stack.isEmpty()) res.add(stack.pop());
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
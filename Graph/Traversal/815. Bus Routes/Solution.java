class Solution {
    public int numBusesToDestination(int[][] routes, int start, int end) {
        if (start == end) return 0;
        Map<Integer,Set<Integer>> map = buildGraph(routes);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        Set<Integer> isVisited = new HashSet<>();
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0 ; i < size ; i++) {
                int cur = queue.poll();
                Set<Integer> routeNumbers= map.get(cur);
                for(int routeNumber : routeNumbers) { 
                    if (isVisited.contains(routeNumber)) continue;
                    isVisited.add(routeNumber);
                    for(int stop : routes[routeNumber]) {
                        if (stop == end) return res;
                        queue.offer(stop);
                    }
                }
            }
        }
        return -1;
    }
    
    private Map<Integer,Set<Integer>> buildGraph(int[][] routes) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for (int i = 0 ; i < routes.length ; i++) {
            for (int j : routes[i]) {
                map.computeIfAbsent(j,set -> new HashSet<>()).add(i);
            }
        }
        return map;
    }
}
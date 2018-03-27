class Solution {
    public int findCheapestPrice(int n, int[][] flights, int start, int end, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        
        int[][] adjCost = new int[n][n];
        
        for(int[] flight : flights){
            adjCost[flight[0]][flight[1]] = flight[2]; 
        }
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size(); 
            for (int i = 0 ; i < size; i++){
                int cur = queue.poll();
                for (int[] flight : flights){
                    int u = flight[0];
                    int v = flight[1];
                    if(steps == k && v != end ) continue; 
                    if(cur == u && cost[v] > cost[u] + adjCost[u][v]){
                        cost[v] = cost[u] + adjCost[u][v];
                        queue.add(v);
                    }
                }
            }
            steps++;
        }
    return cost[end] == Integer.MAX_VALUE ? -1 : cost[end];
    }
}
class Solution {
    // modulo operation: https://www.geeksforgeeks.org/modulo-1097-1000000007/
    // Just for preventing integret overflow, can igore for now
    int mod = 1_000_000_007;

    public int countPaths(int n, int[][] roads) { 
        List<int[]>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<int[]>();
        }

        // Build Cost Graph
        for(int[] road: roads) {
            int start = road[0], end = road[1], time = road[2];
            
            // Why we need to add both start and end?
            // Because it's possible that we traverse from both directions
            graph[start].add(new int[]{end, time});
            graph[end].add(new int[]{start, time});
        }
        
        //  Travel from pos 0 to pos n - 1 in the shortest amount of time.
        return helper(graph, 0 , n);
    }
    private int helper(List<int[]>[] graph, int src, int target){
        // Pair<Pos, MinCost>
        PriorityQueue<long[]> pq = new PriorityQueue<long[]>((a,b)->Long.compare(a[1], b[1]));

        long[] posToMinCount = new long[target];
        long[] posToMinCost = new long[target];
        Arrays.fill(posToMinCost, Long.MAX_VALUE);

        posToMinCount[0] = 1;
        posToMinCost[0] = 0;

        pq.offer(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] current = pq.poll();

            int pos = (int)current[0];
            long cost = current[1];
            
            // Higher cost just skip
            if (cost > posToMinCost[pos]) continue;
            
            // Iterate through Pair<Pos, MinCost> around the current pos
            for (int[] n: graph[pos]) {
                int nextPos = n[0], time = n[1];
                // Check each neighbourhood of pos
                // If we find a smaller cost then we update posToMinCost mapping 
                // The mapping starts with Long.MAX_VALUE
                if(cost + time < posToMinCost[nextPos]){
                    posToMinCost[nextPos] = cost + time;
                    pq.offer(new long[]{(long)nextPos, posToMinCost[nextPos]});
                    posToMinCount[nextPos] = posToMinCount[pos];                        
                }
                // For example 
                // posToMinCount[pos] = 4, posToMinCount[nextPos]
                // Then there is new 9 ways of min cost to posToMinCount[nextPos], 
                // so we need to update the value of this indeex
                else if(cost + time == posToMinCost[nextPos]){
                    posToMinCount[nextPos] = (posToMinCount[nextPos] + posToMinCount[pos]) % mod;
                 }
             }
        }
        
        return (int)posToMinCount[target-1];

    }
}
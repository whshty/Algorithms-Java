class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        if(times == null || times.length == 0) return -1;

        Map<Integer,Map<Integer, Integer>> path = new HashMap<>();
        for(int[] time : times){
            path.putIfAbsent(time[0],new HashMap<>());
            Map<Integer, Integer> sourceMap = path.get(time[0]);
            Integer dist = sourceMap.get(time[1]);
            if( dist == null || dist > time[2]) sourceMap.put(time[1], time[2]);
        }

        Map<Integer, Integer> distMap = new HashMap<>();
        distMap.put(K, 0);
        PriorityQueue<int[]> heap = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
        heap.offer(new int[]{K, 0});
        int max = -1;
        while(!heap.isEmpty()){
            int[] cur = heap.poll();
            int node = cur[0];
            int distance = cur[1];

            if(distMap.containsKey(node) && distMap.get(node) < distance) continue;

            Map<Integer, Integer> sourceMap = path.get(node);
            if(sourceMap == null) continue;

            for(Map.Entry<Integer, Integer> entry : sourceMap.entrySet()){
                int newDist = distance + entry.getValue();
                int targetNode = entry.getKey();
                if(distMap.containsKey(targetNode) && distMap.get(targetNode) <= newDist ) continue;
                distMap.put(targetNode, newDist);
                heap.offer(new int[]{targetNode, newDist});
            }
        }
        // get the largest absolute distance.
        for(int val : distMap.values()) if(val > max) max = val;
        return distMap.size() == N ? max : -1;
    }
}

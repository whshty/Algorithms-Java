class Solution {
    public int networkDelayTime(int[][] times, int n, int dept) {
        if (times == null || times.length == 0) return -1;

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            Map<Integer, Integer> sourceMap = map.get(time[0]);
            Integer cost = sourceMap.get(time[1]);
            if (cost == null || cost > time[2]) sourceMap.put(time[1], time[2]);
        }

        Map<Integer, Integer> nodeToDist = new HashMap<>();
        nodeToDist.put(dept, 0);
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        heap.offer(new int[]{dept, 0});
        int max = -1;
        while (!heap.isEmpty()) {
            int[] nodeAndCost = heap.poll();
            int node = nodeAndCost[0];
            int cost = nodeAndCost[1];

            if (nodeToDist.containsKey(node) && nodeToDist.get(node) < cost) continue;

            Map<Integer, Integer> targetToCost = map.get(node);
            if (targetToCost == null) continue;

            for (Map.Entry<Integer, Integer> entry : targetToCost.entrySet()) {
                int newCost = cost + entry.getValue();
                int target = entry.getKey();
                if (nodeToDist.containsKey(target) && nodeToDist.get(target) <= newCost) continue;
                nodeToDist.put(target, newCost);
                heap.offer(new int[]{target, newCost});
            }
        }
        for (int val : nodeToDist.values()) if (val > max) max = val;
        return nodeToDist.size() == n ? max : -1;
    }
}
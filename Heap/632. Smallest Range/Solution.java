class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++) {
        	max = Math.max(max, nums.get(i).get(0));
            // {firstValue, index ,  0}
        	minHeap.add(new int[] {nums.get(i).get(0), i, 0});
        }
        int[] res = new int[]{minHeap.peek()[0], max};
        while(res[1] - res[0] != 0 && minHeap.peek()[2] + 1 < nums.get(minHeap.peek()[1]).size()) {
        	int[] cur = minHeap.poll();
        	minHeap.add(new int[] {nums.get(cur[1]).get(cur[2] + 1), cur[1], cur[2] + 1});
        	max = Math.max(max, nums.get(cur[1]).get(cur[2] + 1));
        	if(max - minHeap.peek()[0] < res[1] - res[0]) {
                res = new int[] {minHeap.peek()[0], max};
            }    
        }
        return res;
    }
}
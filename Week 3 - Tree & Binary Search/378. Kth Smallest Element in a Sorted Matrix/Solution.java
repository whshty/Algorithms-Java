public class Solution {
    public int kthSmallest(int[][] ma, int k) {
        int n = ma.length;
        Queue<int[]> heap= new PriorityQueue<>(Comparator.comparingInt(e -> ma[e[0]][e[1]]));
        for (int i = 0; i < n; i++) heap.offer(new int[]{i, 0});
        while (k-- > 1) {
            int[] e = heap.poll();
            if (++e[1] < n) heap.offer(e);
        }
        if( heap.isEmpty()) return 0;
        else return ma[heap.peek()[0]][heap.peek()[1]];
    }
}
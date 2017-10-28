class Solution {
    public double knightProbability(int N, int K, int row, int col) {
        int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        int steps = K;
        while (steps-- > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < dirs.length; j++) {
                    int[] dir = dirs[j];
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < N && y >= 0 && y < N) {
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        double prob = queue.size();
        for (int i = 0; i < K; i++) {
            prob = prob / 8;
        }
        return prob;
    }
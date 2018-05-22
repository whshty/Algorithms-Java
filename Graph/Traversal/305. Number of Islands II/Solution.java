public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;

        int count = 0;
        int[] nums = new int[m * n];
        Arrays.fill(nums, -1);

        for (int[] position : positions) {
            int id = n * position[0] + position[1];
            nums[id] = id;
            count++;

            for (int[] dir : dirs) {
                int x = position[0] + dir[0];
                int y = position[1] + dir[1];
                int pos = n * x + y;
                if (x < 0 || x >= m || y < 0 || y >= n || nums[pos] == -1) continue;
                int rootId = find(nums, pos);
                if (id != rootId) {
                    // Union
                    nums[id] = rootId;
                    id = rootId;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }

    private int find(int[] nums, int id) {
        while (id != nums[id]) id = nums[id];
        return id;
    }
}
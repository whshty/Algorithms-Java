// MEMO DFS
class Solution {
    public int numSquares(int n) {
        return dfs(new HashMap<>(),n);
    }
    
    private int dfs(Map<Integer,Integer> map, int val) {
        if (val == 0) return 0;
        if (val == 1) return 1;
        if (map.containsKey(val)) return map.get(val);
        
        int sqrtVal = (int)Math.sqrt(val);
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i <= sqrtVal; i++) {
            int leftVal = val - i * i;
            min = Math.min(min, dfs(map, leftVal) + 1);
        }
        map.put(val,min);
        return min;
    }
}
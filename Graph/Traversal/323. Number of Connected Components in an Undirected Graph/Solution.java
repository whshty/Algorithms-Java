public class Solution {
    public int countComponents(int n, int[][] edges) {
        int res = 0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for( int i = 0 ; i < n ; i++) map.put(i, new ArrayList<>());
        
        for( int[] e : edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);    
        }
        for (int i = 0; i < n; i++) {
            if (set.add(i)) {
                helper(i, map, set);
                res++;
            }
        }
        return res;
    }
    private void helper(int i, Map<Integer, List<Integer>> map, Set<Integer> set) {
        for (int j : map.get(i)) {
            if (set.add(j)) helper(j, map, set);    
        }
    }
}
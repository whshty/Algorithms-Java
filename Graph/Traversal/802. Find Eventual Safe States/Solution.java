// 1:safe
// 2:unsafe
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if (graph == null || graph.length == 0) return res;
        int size = graph.length;
        int[] colors = new int[size];
            
        for (int i = 0 ; i < size ; i++) {
            if(dfs(graph,colors,i)) res.add(i);
        }
        return res;
    }
    
    private boolean dfs(int[][] graph, int[] colors, int i) {
        if(colors[i] != 0) return colors[i] == 1;
        
        colors[i] = 2;
        for (int nextNode : graph[i]) {
            if (!dfs(graph, colors, nextNode)) return false;    
        }
        colors[i] = 1;
        return true;
    }
}
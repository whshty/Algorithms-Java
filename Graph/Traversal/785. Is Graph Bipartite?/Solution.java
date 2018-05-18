// BFS + color array
class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) return true;
        
        int[] color = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0 ; i < graph.length ; i++){
            if (color[i] == 0) {
                queue.add(i);
                color[i] = 1;
                while (queue.size() != 0) {
                    int node = queue.remove();
                    for( int nextNode : graph[node]){
                        if( color[nextNode] == 0 ){
                            color[nextNode] = color[node] == 1 ? 2 : 1;
                            queue.add(nextNode);    
                        } 
                        else if (color[nextNode] == color[node]) return false;
                    }
                }
            }
        }
        return true;
    }
}

// DFS 

// didn't check :0
// color 1 : 1
// color 2 : 2
class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) return true;
        int[] colors = new int[graph.length];
        
        for (int i = 0 ; i < graph.length ; i++) {
            if (colors[i] == 0 && !isValid(graph, colors, i, 1)) return false;
        }
        return true;
    }
    
    public boolean isValid(int[][] graph, int[] colors, int index, int val){
        if (colors[index] != 0 ) {
            return colors[index] == val;
        }
        colors[index] = val;
        int nextVal = val == 1 ? 2 : 1;
        for( int node : graph[index] ){
            if(!isValid(graph, colors, node, nextVal)) return false;
        }
        return true;
    }
}
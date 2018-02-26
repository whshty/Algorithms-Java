// BFS + color array
class Solution {
    public boolean isBipartite(int[][] graph) {
        if ( graph == null || graph.length == 0 ) return true;
        
        int[] color = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for( int i = 0 ; i < graph.length ; i++ ){
            if( color[i] == 0 ) {
                queue.add(i);
                color[i] = 1;
                while( queue.size() != 0 ) {
                    int node = queue.remove();
                    for( int temp : graph[node]){
                        if( color[temp] == 0 ){
                            color[temp] = color[node] == 2 ? 1 : 2;
                            queue.add(temp);    
                        } 
                        else if ( color[temp] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] unionSet = new int[2001];
        for( int i = 0 ; i < unionSet.length ; i++ ) unionSet[i] = i;
        
        for( int[] edge : edges ){
            int id1 = edge[0] , id2 = edge[1];
            if( find(unionSet,id1) == find(unionSet,id2) ) return edge;
            else unionSet[find(unionSet,id1)] = find(unionSet,id2);
        }
        return new int[2];
    }
    private int find(int[] unionSet , int id){
        if( id != unionSet[id] ){
            unionSet[id] = find(unionSet,unionSet[id]);
        }
        return unionSet[id];
    }
}
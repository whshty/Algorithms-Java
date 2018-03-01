## Union Find
```java
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] union = new int[2001];
        for( int i = 0 ; i < union.length ; i++ ) union[i] = i;
        
        for( int[] edge : edges ){
            int edge1 = edge[0] , edge2 = edge[1];
            int id1 = find(union,edge1), id2 = find(union,edge2);
            if( id1 == id2 ) return edge;
            else union[id2] = id1;
        }
        return new int[2];
    }
    
    public int find(int[] union, int id){
        if( union[id] != id){
            union[id] = find(union,union[id]);
        }
        return union[id];
    }
}
```
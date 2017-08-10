public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if( n < 1 ) return false;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for( int i = 0 ; i < n ; i++ ) {
            map.put(i,new HashSet<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        
        while(!queue.isEmpty()){
            int entry = queue.remove();
            if( set.contains(entry)) return false;
            for( int node : map.get(entry)){
                queue.add(node);
                map.get(node).remove(entry);
            }
            set.add(entry);
        }
        return set.size() == n;
    }
}


public class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        
        for( int i = 0 ; i < n ; i++ ){
            list.add(new ArrayList<Integer>());
        }
        
        for( int i = 0 ; i < edges.length ; i++ ){
            int temp1 = edges[i][0], temp2 = edges[i][1];
            list.get(temp1).add(temp2);
            list.get(temp2).add(temp1);
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        
        boolean res = hasCycle(list,set,0,-1);
        if(!res) return false;
        return set.size() == n ? true : false;
    }
    
    private boolean hasCycle(List<List<Integer>> lists, Set<Integer> set , int cur, int parent){
        List<Integer> list = lists.get(cur);
        
        for( int temp : list ){
            if( temp == parent ) continue;
            if( set.contains(temp) ) return false;
            set.add(temp);
            boolean res = hasCycle(lists,set,temp,cur);
            if( !res ) {
                return false;
            }
        }
        return true;
    }
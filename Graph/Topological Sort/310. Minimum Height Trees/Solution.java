public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> entry = new ArrayList<>();
        if( n ==  1) {
            entry.add(0);
            return entry;
        }
        List<Set<Integer>> list = new ArrayList<>();
        for( int i = 0 ; i < n ; i++ ){
            list.add(new HashSet<>());
        }
        for( int[] edge : edges ){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        
        for( int i = 0 ; i < n ; i++ ){
            if( list.get(i).size() == 1 ) entry.add(i);
        }
        
        int count = n;
        while( count > 2 ){
            count -= entry.size();
            List<Integer> newEntry = new ArrayList<>();
            for( int i : entry ){
                int temp = list.get(i).iterator().next();
                list.get(temp).remove(i);
                if( list.get(temp).size() == 1 ){
                    newEntry.add(temp);
                }
            }
            entry = newEntry;
        }
        return entry;
    }
}
```java
class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];
        int count = numCourses;
        
        Map<Integer,List<Integer>> map = getAdjacencLists(pre);
        for( int i = 0 ; i < pre.length ; i++ ) indegree[pre[i][0]]++;
        
        for( int i = 0 ; i < numCourses ; i++ ){
            if( indegree[i] == 0 ) queue.offer(i);
        }
        
        while( !queue.isEmpty()){
            int cur = queue.poll();
            if( map.get(cur) == null ) {
                count--;
                continue;
            }    
            for( int i : map.get(cur)){
                if( --indegree[i] == 0 ){
                    queue.offer(i);
                }
            }
            count--;
        }
        return count == 0;
    }
    
    private Map<Integer,List<Integer>> getAdjacencLists(int[][] pre){
        Map<Integer,List<Integer>> map = new HashMap<>();
        for( int i = 0 ; i < pre.length ; i++ ){
            map.putIfAbsent(pre[i][1],new ArrayList<>());
            map.get(pre[i][1]).add(pre[i][0]);
        }
        return map;
    }
}
```
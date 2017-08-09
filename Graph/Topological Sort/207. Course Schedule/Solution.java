public class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];
        int count = numCourses;
        
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for( int i = 0 ; i < pre.length ; i++ ){
            map.getOrDefault(pre[i][0],new ArrayList<Integer>()).add(pre[i][1]);
            indegree[pre[i][1]]++;
        }
        for( int i = 0 ; i < numCourses ; i++ ){
            if( indegree[i] == 0 ){
                queue.offer(i);
            }
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
}
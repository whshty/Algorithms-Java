```
public class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        if( numCourses == 0 ) return null;
        // // Convert graph presentation from edges to indegree of adjacent list.      
        int indegree[] = new int[numCourses];
        Map<Integer,Set<Integer>> map = getAdjacencLists(pre);
        
        System.out.println(map);
        
        int[] res = new int[numCourses];
       
        for( int i = 0 ; i < pre.length; i++) indegree[pre[i][0]]++; 
        int index = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for( int i = 0 ; i < numCourses; i++ ){
            if( indegree[i] == 0){
                res[index++] = i;
                queue.offer(i);
            }
        }
        
        
        while(!queue.isEmpty()){
            // Already finished this prerequisite course
            int basicCourse = queue.poll();
            if (map.containsKey(basicCourse));{
                Set<Integer> set = map.get(basicCourse);
                if( set == null || set.size() == 0 ) continue;
                for( int i : set ){
                    indegree[i]--;
                    if( indegree[i] == 0 ){
                        res[index++] = i;
                        queue.offer(i);
                    }
                }
            }
        }
        return (index == numCourses) ? res : new int[0];
    }
    
    private Map<Integer,Set<Integer>> getAdjacencLists(int[][] pre){
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for( int i = 0 ; i < pre.length ; i++ ){
            map.putIfAbsent(pre[i][1],new HashSet<>());
            map.get(pre[i][1]).add(pre[i][0]);
        }
        return map;
    }
}
```
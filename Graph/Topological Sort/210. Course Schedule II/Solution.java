public class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        if( numCourses == 0 ) return null;
        // // Convert graph presentation from edges to indegree of adjacent list.
        int indegree[] = new int[numCourses], res[] = new int[numCourses];
        int index = 0;
        for( int i = 0 ; i < pre.length; i++){
            indegree[pre[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for( int i = 0 ; i < numCourses; i++ ){
            if( indegree[i] == 0){
                res[index++] = i;
                queue.offer(i);
            }
        }
        
        // How many courses don't need preequisties
        while(!queue.isEmpty()){
            // Already finished this prerequisite course
            int basicCourse = queue.poll();
            for( int i = 0 ; i < pre.length; i++){
                if( pre[i][1] == basicCourse ){
                    indegree[pre[i][0]]--;
                    if( indegree[pre[i][0]] == 0){
                        // If indegree is zero, then add the course to the order.
                        res[index++] = pre[i][0];
                        queue.offer(pre[i][0]);
                    }
                }
            }
        }
        return (index == numCourses) ? res : new int[0];
    }
}
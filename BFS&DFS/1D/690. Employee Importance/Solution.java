class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int res = 0;
        Map<Integer,Employee> map = new HashMap<>();
        for(Employee employee : employees){
            map.put(employee.id,employee);
        }
        Queue<Employee> queue = new LinkedList<>();    
        queue.offer(map.get(id));
        
        while( !queue.isEmpty()){
            Employee cur = queue.poll();
            res += cur.importance;
            for( int temp : cur.subordinates){
                queue.offer(map.get(temp));
            }
        }
        return res;
    }
}
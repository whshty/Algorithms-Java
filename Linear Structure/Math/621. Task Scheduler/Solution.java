class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        int maxFreq = 0;
        int maxCount = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(char task : tasks){
            if(!map.containsKey(task)){
                map.put(task,1);
            } else{
                map.put(task,map.get(task)+1);
            }
            if( maxFreq < map.get(task)){
                maxFreq = map.get(task);
                maxCount = 1;
            } else if ( maxFreq == map.get(task)){
                maxCount++;
            }
            
        }
        return Math.max(tasks.length,(n+1)*(maxFreq-1) + maxCount);
    }
}
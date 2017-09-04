### Can reorder 
* The result is decided by the maximum count and the number of tasks with maximum count
* The min result is the length of the tasks
* Consider k+1 as a time slot

```
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
```

### Cannot reorder 
```
class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        int[] test = {1,1,2,2,1};
        myCode sol = new myCode();
        System.out.println(sol.task(test,2));
    }
    public int task(int[] tasks, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int task : tasks){
            if(map.containsKey(task)){
                int endTime = map.get(task) + k + 1;
                if( endTime > res){
                    res = endTime;
                } else{
                    res++;
                }
            } else res++;
            map.put(task,res);
        }
        return res;
        
    }
}

```
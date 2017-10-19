### Stack

```java
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        int pre = 0;
        for(String str : logs){
            String[] parts = str.split(":");
            int id = Integer.parseInt(parts[0]);
            int cur = Integer.parseInt(parts[2]);
            
            if(parts[1].equals("start")){
                if(!deque.isEmpty()) {
                    // start a function 
                    res[deque.peekLast()] += cur - pre;
                }
                deque.addLast(id);
                pre = cur;
            } 
            // end 
            else {
                // cur is end of current interval, belong to current interval. That's why we have + 1 here
                res[id] += cur - pre + 1; 
                deque.removeLast();
                //res[deque.removeLast()] += cur - pre + 1; is also okay
                // pre means the start of next interval, so we need to + 1
                pre = cur + 1;  
            }
        }
        return res;
    }
}
```
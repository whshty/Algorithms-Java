### Sliding Window of Size k

```
class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        int[] input = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(input,3);
        
        for( int i : res ){
            System.out.print(i);
        }
        
    }
    public static int[] maxSlidingWindow(int[] n, int k) {
        int[] res = new int[n.length-2];
        int start = 0 , end = k - 1 , len = k;
        while( end < n.length ){
            res[start] = getMax(n,start++,end++);
            
        }
        return res;

    }
    private static int getMax(int[] n, int start, int end){
        int res = Integer.MIN_VALUE;
        for( int i = start ; i <= end ; i++ ){
            res = Math.max(res,n[i]);
        }
        return res;
    }
    
}
```

### Deque

```
class Solution {
    public int[] maxSlidingWindow(int[] n, int k) {
        if( n == null || k <= 0 ) return new int[0];
        int len = n.length;
        int[] res = new int[len-k+1];
        int index = 0;
        
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0 ; i < len ; i++ ){
            while( !deque.isEmpty()  && deque.peek() < i - k + 1 ){
                deque.poll();
            }
            while( !deque.isEmpty() && n[deque.peekLast()] < n[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if( i >= k - 1 ){
                res[index++] = n[deque.peek()];
            }
        }
        return res;
    }
}
```
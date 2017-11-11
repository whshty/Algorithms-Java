## 2.DP
* Time : O(n^2)

## 3.Binary Search + DP
* Time : O(nlogn)
```
10, 9, 2, 5, 3, 7, 101, 18

10 
9
2
2,5
2,3
2,3,7
2,3,7,101
2,3,7,18
```

```java
public class Solution {
    public int lengthOfLIS(int[] input) {
        if(input == null || input.length == 0 ) return 0;
        int[] dp = new int[input.length];
        dp[0] = input[0];
        int index = 0;
        for( int i = 1; i < input.length; i++){
            int pos = binarySearch(dp,index,input[i]);
            if( input[i] < dp[pos]) dp[pos] = input[i];
            if( pos > index){
                index = pos;
                dp[index] = input[i];
            }
        }
        return index+1;
    }
    public int binarySearch(int[] arr, int len, int target){
        int start = 0;
        int end = len;
        while( start + 1 <  end ){
            int mid = ( start + end ) >>> 1;
            if(arr[mid] == target) return mid;
            else{
                if(arr[mid] < target) start = mid;
                else end = mid;
            }
        }
        if( arr[end] < target) return len+1;
        else if (arr[start] >= target) return start;
        else return end;
    }
}
```
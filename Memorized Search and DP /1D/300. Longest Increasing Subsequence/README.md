## 1.DFS

## 2.DP
* Time : O(n^2)

由于这个最长上升序列不一定是连续的，对于每一个新加入的数，都有可能跟前面的序列构成一个较长的上升序列，或者跟后面的序列构成一个较长的上升序列。比如1,3,5,2,8,4,6，对于6来说，可以构成1,3,5,6，也可以构成2,4,6。因为前面那个序列长为4，后面的长为3，所以我们更愿意6组成那个长为4的序列，所以对于6来说，它组成序列的长度，实际上是之前最长一个升序序列长度加1，注意这个最长的序列的末尾是要小于6的，不然我们就把1,3,5,8,6这样的序列给算进来了。这样，我们的递推关系就隐约出来了，假设dp[i]代表加入第i个数能构成的最长升序序列长度，我们就是要在dp[0]到dp[i-1]中找到一个最长的升序序列长度，又保证序列尾值nums[j]小于nums[i]，然后把这个长度加上1就行了。同时，我们还要及时更新最大长度。

```java
public class Solution {
    public int lengthOfLIS(int[] input) {
        if (input.length == 0) return 0;
        int len = input.length, max = 0;
        // dp[i] means the longest length til ith position
        int[] dp = new int[len];
        
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

```


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
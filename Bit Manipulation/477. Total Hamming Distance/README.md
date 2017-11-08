## 1.Brute Force - Use XOR to find the different bit
```java
class Solution {
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        for(int i = 0 ; i < nums.length - 1 ; i++ ){
            for( int j = i + 1 ; j < nums.length ; j++ ){
                count += hammingDistance(nums[i],nums[j]);
            }
        }
        return count;
    }
    public int hammingDistance(int x, int y) {
        // 177 = 10110001
    	 // Integer.bitCount(177) = 4
        return Integer.bitCount(x^y);
    }
}
```

## 2.Optimization
* Suppose that i numbers have a rightmost 0-bit
* and j numbers have a 1-bit. 
* Then out of the pairs, i * j of them will have 1 in the rightmost bit of the XOR.

```
1,1,1,0,0

The result will be 3 * 2

```

```java
class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = 31;
        int len = nums.length;
        int[] count = new int[n];
        
        for( int i = 0 ; i < len ; i++ ){
            for( int j = 0 ; j < n ; j++){
                count[j] += (nums[i] >> j) & 1;
            }
        }
        int res = 0;
        for( int i : count){
            res += i * ( len - i);
        }
        return res;

    }
}
```
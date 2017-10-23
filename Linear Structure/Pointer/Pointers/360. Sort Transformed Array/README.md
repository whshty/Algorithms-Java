```java
public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int index = a >= 0 ? nums.length - 1 : 0;
        while( start <= end ){
            int startVal = calculate(nums[start],a,b,c);
            int endVal = calculate(nums[end],a,b,c);
            if( a >= 0 ){
                if( startVal >= endVal ){
                    res[index--] = startVal;
                    start++;
                } else{
                    res[index--] = endVal;
                    end--;
                }
            } else {
                if(startVal <= endVal) {
                    res[index++] = startVal;
                    start++;
                }
                else{
                    res[index++] = endVal;
                    end--;
                }
            }
        }
        return res;
    }
    private int calculate(int x, int a , int b , int c){
        return a * x * x + b * x + c;
    }
}
```
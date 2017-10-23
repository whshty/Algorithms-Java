### Two Pointers 

### f(x) = x^2
```
-5,-1,2,4 
a = 1, b = 0 , c = 0

res : 
n,n,n,25
n,n,16,25
1,n,16,25 
1,4,16,25 
```
```java
public class Solution {
    public int[] sortTransformedArray(int[] nums) {
        int[] res = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length - 1;
        while( start <= end ){
            int startVal = calculate(nums[start]);
            int endVal = calculate(nums[end]);
    
            if( startVal >= endVal ){
                res[index--] = startVal;
                start++;
            } else{
                res[index--] = endVal;
                end--;
            }
           
        }
        return res;
    }
    private int calculate(int x){
        return x * x ;
    }
}
```



### f(x) = ax^2 + bx + c

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
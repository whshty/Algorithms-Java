### Subtract b and count
```java
class Solution {
    public int divide(int a, int b) {
        if( a == 0) return 0;
        if( b == 1) return a;
        if( b == 0 || (b == -1 && a == Integer.MIN_VALUE)) return Integer.MAX_VALUE;
        int sign = (a > 0 && b > 0) || ( a < 0 && b < 0) ? 1 : -1;
        
        long first = Math.abs((long)a) , second = Math.abs((long)b);
        if( first < second ) return 0;
        int res = 0;
        while( first >= second ){
            long temp = second;
            int count = 1;
            res += count;
            first = first - temp;
        }
        return res * sign;
    }
}
```
### Divide and Conquer
```
32/3 = 10

32 - 3 * 2^3 =  32 - 24 = 8  count = 8
8 - 3 * 2   =  2  count = 8 + 2 = 10

```


``` java

class Solution {
    public int divide(int a, int b) {
        if( a == 0) return 0;
        if( b == 1) return a;
        if( b == 0 || (b == -1 && a == Integer.MIN_VALUE)) return Integer.MAX_VALUE;
        int sign = (a > 0 && b > 0) || ( a < 0 && b < 0) ? 1 : -1;
        
        long first = Math.abs((long)a) , second = Math.abs((long)b);
        if( first < second ) return 0;
        int res = 0;
        while( first >= second ){
            long temp = second;
            int count = 1;
            while( temp * 2 <= first ){
                temp =  temp * 2;  
                count = count * 2;
            }
            res += count;
            first = first - temp;
        }
        return res * sign;
    }
}
```

```java
class Solution {
    public int divide(int a, int b) {
        if( a == 0) return 0;
        if( b == 1) return a;
        if( b == 0 || (b == -1 && a == Integer.MIN_VALUE)) return Integer.MAX_VALUE;
        int sign = (a > 0 && b > 0) || ( a < 0 && b < 0) ? 1 : -1;
        long first = Math.abs((long)a) , second = Math.abs((long)b);
        if( first < second) return 0;
        int res = 0;
        while( first >= second ){
            long temp = second;
            int count =1;
            while( (temp << 1) <= first){
                temp <<= 1;
                count <<= 1;
            }
            res += count;
            first = first - temp;
        }
        return res*sign;
    }
}
```
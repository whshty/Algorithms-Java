```
class Solution {
    public int divide(int a, int b) {
        if( a == 0) return 0;
        if( b == 1) return a;
        if( b == 0 || (b == -1 && a == Integer.MIN_VALUE)) return Integer.MAX_VALUE;
        return a / b;
    }
}
```

整数近似除法：32/3 = 10

显然求近似除法可以用乘法来二分查找：32 ~ 3*10 = 3*[1*(2^3) + 0*(2^2) + 1*(2^1) + 0*(2^0)]

```

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

```

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
## Fibonacci
### 1.Brute Force
* O(2^n)

```
                        fib(5)   
                     /             \     
               fib(4)                fib(3)   
             /      \                /     \
         fib(3)      fib(2)         fib(2)    fib(1)
        /     \        /    \       /    \  
  fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
  /    \
fib(1) fib(0)
```

```
class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        System.out.println(fibo(10));        
    }
    public static int fibo(int n){
        if( n < 1 ) return 0;
        if( n == 1 || n == 2) return 1;
        return fibo(n-1) + fibo(n-2);
    }
    
}
```


### 2.Iteration
* O(n)

```
class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        System.out.println(fibo(10));        
    }
    public static int fibo(int n){
        if( n < 1 ) return 0;
        if( n == 1 || n == 2) return 1;
        int res = 1;
        int pre = 1;
        int temp = 0;
        for( int i = 3 ; i <= n ; i++ ){
            temp = res;
            res = res + pre;
            pre = temp;
        }
        return res;
    }    
}

```
# 1.DP Problem
1. Count problem
	* How many ways from A to B
	* How many ways to generate K sum

2. Calculate the min and max value
	* Longest Consecutive Sequence

3. Find if it's possible
	* Can we find k sum which equals to a certain sum?

# 2.How to solve DP problem
1. Define status
	* The last step
	* convert it to sub problem
2. State transfer function
3. Initial condition and corner case
4. Order of calcuation



# 3.Example
### 3.11.Fibonacci
#### Brute Force
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


#### Iteration
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
### Push twice if there is a new min value
```java
public class MinStack {
    /** initialize your data structure here. */
    Deque<Integer> stack = new ArrayDeque<Integer>();
    int min = Integer.MAX_VALUE;
    public void push(int x) {
        if ( x <= min ){
            stack.addFirst(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if (stack.peek() == min) {
            stack.removeFirst();
            min = stack.removeFirst();
        } else stack.removeFirst();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
```
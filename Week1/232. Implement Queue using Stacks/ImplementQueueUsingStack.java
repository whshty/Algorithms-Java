class MyQueue {
    // Push element x to the back of queue.
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    private int front;
    public void push(int x) {
        if (s1.isEmpty()) front = x;
        while ( !s1.isEmpty()){
            s2.push(s1.pop());
        }
        //if (s1.isEmpty()) front = x;
        s2.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        s1.pop();
        if ( !s1.isEmpty() ){
            front = s1.peek();
        }
    }

    // Get the front element.
    public int peek() {
        return front;
        
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty();
    }
}
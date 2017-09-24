class Solution {
    public int calPoints(String[] ops) {
        int res = 0;   
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < ops.length; i++) {
            String s = ops[i];
            
            if (s.equals("C")) {
                int last = stack.pop();
                res -= last;
            } else if (s.equals("D")) {
                int last = stack.peek();
                int num = last*2;
                res += num;
                stack.push(num);
            } else if (s.equals("+")) {
                int prev = stack.pop();
                int num = prev + stack.peek();
                res += num;
                stack.push(prev);
                stack.push(num);
            } else {
                int num = Integer.parseInt(s);
                res += num;
                stack.push(num);
            }
        }
        return res;
    }
}


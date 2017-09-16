class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int pre = 0;
        for(String str : logs){
            String[] parts = str.split(":");
            int cur = Integer.parseInt(parts[2]);
            if(!stack.isEmpty()) res[stack.peek()] += cur - pre;
            pre = cur;
            if(parts[1].equals("start")) stack.push(Integer.parseInt(parts[0]));
            else{ 
                res[stack.pop()]++;
                pre++;
            }
        }
        return res;
    }
}
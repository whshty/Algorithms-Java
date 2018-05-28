// Stack
class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> leftIndex = new ArrayDeque<>();
        Deque<Integer> starIndex = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                leftIndex.push(i);
            } else if (ch == '*') {
                starIndex.push(i);
            } else {
                if (leftIndex.isEmpty() && starIndex.isEmpty()) return false;
                if (!leftIndex.isEmpty()) leftIndex.pop();
                else starIndex.pop();
            }
        }
        
        while (!leftIndex.isEmpty() && !starIndex.isEmpty()) {
            if (leftIndex.pop() > starIndex.pop()) return false;
        }
        
        return leftIndex.isEmpty();
    }
}

// DFS 
class Solution {
    public boolean checkValidString(String s) {
        return dfs(s, 0, 0);
    }
    
    private boolean dfs(String s, int pos, int count) {
        if (count < 0) return false;
        
        for (int i = pos; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            else if (c == ')') {
                if (count <= 0) return false;
                count--;
            }
            else if (c == '*') return dfs(s, i + 1, count + 1) || dfs(s, i + 1, count - 1) || dfs(s, i + 1, count);
        }
        
        return count == 0;
    }
}

// Greedy
class Solution {
    public boolean checkValidString(String s) {
       int start = 0, end = 0;
       for (char ch : s.toCharArray()) {
           start += ch == '(' ? 1 : -1;
           end += ch == ')' ? -1 : 1;
           if (end < 0) break;
           start = Math.max(start, 0);
       }
       return start == 0;
    }
}
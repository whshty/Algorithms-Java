class Solution {
    public String decodeString(String s) {
        Deque<Integer> valStack = new ArrayDeque<>();
        Deque<StringBuilder> sbStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int val = 0;
        
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) val = val * 10 + ch - '0';
            else if (ch == '[') {
                valStack.push(val);
                val = 0;
                sbStack.push(sb);
                sb = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder tempSb = sb;
                sb = sbStack.pop();
                int count = valStack.pop();
                for (int i = 0; i < count; i++) {
                    sb.append(tempSb);
                }            
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
class Solution {
    boolean res = false;

    public boolean checkValidString(String s) {
        helper(new StringBuilder(s), 0);
        return res;
    }

    public void helper(StringBuilder sb, int i) {
        if (i == sb.length()) {
            res |= isValid(sb); // res = res || isValid(sb);
        } else if (sb.charAt(i) == '*') {
            for (char c: "() ".toCharArray()) {
                sb.setCharAt(i, c);
                helper(sb, i+1);
                if (res) return;
            }
            sb.setCharAt(i, '*');
        } else helper(sb, i + 1);
    }

    public boolean isValid(StringBuilder sb) {
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) break;
        }
        return count == 0;
    }
}


class Solution {
    public boolean checkValidString(String s) {
       int start = 0, end = 0;
       for (char c: s.toCharArray()) {
           start += c == '(' ? 1 : -1;
           end += c == ')' ? -1 : 1;
           if ( end < 0) break;
           start = Math.max(start, 0);
       }
       return start == 0;
    }
}
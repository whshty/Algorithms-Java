class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (String s : source) {
            int index = 0 ;
            while (index < s.length()) {
                if (flag) {
                    if (s.charAt(index) == '*' && index < s.length() - 1 && s.charAt(index + 1) == '/') {
                        flag = false;
                        index++;
                    }
                }
                else {
                    if (s.charAt(index) == '/' && index < s.length() - 1 && s.charAt(index + 1) == '/') {
                        if (sb.length() > 0)    res.add(sb.toString());
                        sb = new StringBuilder();
                        break;
                    }
                    else if (s.charAt(index) == '/' && index < s.length() - 1 && s.charAt(index + 1) == '*') {
                        flag = true;
                        index++;
                    }
                    else    sb.append(s.charAt(index));
                }
                index++;
            }
            if (index == s.length() && !flag && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
}
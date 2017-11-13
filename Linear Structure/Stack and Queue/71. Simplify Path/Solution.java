//stack
public class Solution {
    public String simplifyPath(String input) {
        if( input == null || input.length() == 0 ) return "";
        Deque<String> stack = new ArrayDeque<>();

        //"" for corner case of "/home//foo/"
        for(String dir : input.split("/")){
            if ( dir.equals(".") || dir.equals("") ) continue;
            else if( dir.equals("..")) {
                if( !stack.isEmpty()) stack.pop();
            }
            else stack.push(dir);
        }


        StringBuilder sb = new StringBuilder();
        if( stack.isEmpty() ) sb.append("/");
        while( !stack.isEmpty()){
            sb.append("/").append(stack.pollLast());
        }
        return sb.toString();
    }
}

// Edit array
public class Solution {
    public String simplifyPath(String input) {
        if (input == null || input.charAt(0) != '/') return null;
        String[] splits = input.split("/");

        int count = 0;
        for (String str : splits) {
            if (str.equals("..") && count > 0) --count;
            else if (!str.equals(".") && !str.equals("..") && !str.equals("")) {
                splits[count++] = str;
            }
        }

        // print new path
        if (count == 0) return "/";
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < count ; ++i) {
            sb.append("/" + splits[i]);
        }
        return sb.toString();
    }
}
public class Solution {
    public String simplifyPath(String path) {
        if( path == null || path.length() == 0 ) return "";
        Deque<String> stack = new ArrayDeque<>();
        
        //"" for corner case of "/home//foo/"
        for(String dir : path.split("/")){
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
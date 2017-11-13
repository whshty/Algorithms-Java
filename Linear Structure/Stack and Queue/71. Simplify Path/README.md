## Stack
```java
public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        Set<String> set = new HashSet<>(Arrays.asList("..",".",""));
        for(String dir : path.split("/")){
            if( dir.equals("..") && !stack.isEmpty()){
                stack.pop();
            } else if ( !set.contains(dir) ){
                stack.push(dir);
            }
        }
        String res = "";
        if(stack.isEmpty()) return "/";
        // "/abc/..." ->  "/abc/..."
        for (String dir : stack) {
            res = "/" + dir + res;
        }
        return res;
    }
}
```
## 1.Stack
```java
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
```

## 2.Edit String Array

```java
public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.charAt(0) != '/') return null;  
        String[] splits = path.split("/");  
   
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
```
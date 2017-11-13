## 1.Stack
```java
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
```

## 2.Edit String Array

```java
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
```

## 3.Two Pointers & In-Place
* If the current split is "/..", back up one level
* If the current split is neither "/." nor "/", copy it to the end of previous valid split.

```java

public class Solution {
    public String simplifyPath(String input) {
        char[] splits = input.toCharArray();
        if (splits == null || splits[0] != '/') return null;

        // end points to the end of previous valid split
        // start points to "/..." of current split

        int end = 0, start = 0, index = 0;
        while  (index < splits.length) {
            if (splits[index] == '/') {
                if (index - start == 3 && splits[index - 1] == '.' && splits[index - 2] == '.') {
                    while (end > 0 && splits[--end] != '/') ;
                }
                else if (index - start > 2 || (index - start == 2 && splits[index - 1] != '.')) {
                    while (start < index) {
                        splits[end++] = splits[start++];
                    }
                }
                start = index;// reset start
            }
            index++;
        }
        // check the last split
        // Input = "/..." , if we don't use the part, we will get "/" instead of "/..."
        if (index > start) {
            if (index - start == 3 && splits[index - 1] == '.' && splits[index - 2] == '.') { 
                while (end > 0 && splits[--end] != '/') ;
            } else if (index - start > 2 || (index - start == 2 && splits[index - 1] != '.')) {
                while (start < index) splits[end++] = splits[start++];
            }
        }

        if (end == 0) splits[end++] = '/';
        return new String(splits, 0, end);
    }
}
```
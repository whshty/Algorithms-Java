### Find One Solution
```java
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if( s == null ) return res;
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        
        queue.add(s);
        visited.add(s);
        
        //boolean isFound = false;
        while( !queue.isEmpty() ){
            s = queue.poll();
            if(isValid(s)){
                res.add(s);
                return res;
                //isFound = true;
            }
            //if(isFound) continue;
            for( int i = 0 ; i < s.length(); i++ ){
                if(s.charAt(i) != '(' && s.charAt(i) != ')') continue;
                String temp = s.substring(0,i) + s.substring(i+1);
                if(!visited.contains(temp)){
                    queue.add(temp);
                    visited.add(temp);
                }
            }
        }
        return res;
    }
    private boolean isValid(String s){
        int count = 0;
        for( int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if( c == '(') count++;
            if( c == ')' && count-- == 0 ) return false;
        }
        return count == 0;
    }
}

```


### Find All Solution : Queue + Set
* Queue : BFS
* Set : Cache search result

```java
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if( s == null ) return res;
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        
        queue.add(s);
        visited.add(s);
        
        boolean isFound = false;
        while( !queue.isEmpty() ){
            s = queue.poll();
            if(isValid(s)){
                res.add(s);
                isFound = true;
            }
            if(isFound) continue;
            for( int i = 0 ; i < s.length(); i++ ){
                if(s.charAt(i) != '(' && s.charAt(i) != ')') continue;
                String temp = s.substring(0,i) + s.substring(i+1);
                if(!visited.contains(temp)){
                    queue.add(temp);
                    visited.add(temp);
                }
            }
        }
        return res;
    }
    private boolean isValid(String s){
        int count = 0;
        for( int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if( c == '(') count++;
            if( c == ')' && count-- == 0 ) return false;
        }
        return count == 0;
    }
}
```
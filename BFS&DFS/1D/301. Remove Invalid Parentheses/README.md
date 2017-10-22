# Find One Solution 
### Brtue Force BFS
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

### Two Pointers

```java
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        res.add(getValidParentheses(s));
        return res;
    }
    public String getValidParentheses(String s){
        StringBuilder firstScan = new StringBuilder();
        int left = 0, right = 0;
        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if ( ch == '(') {
                left++;
                firstScan.append(ch);
            } else if (ch == ')' && right < left) {
                right++;
                firstScan.append(ch);
            } else if ( ch != ')' && ch != '(') {
                firstScan.append(ch);
            }
        }

        left = 0;
        right = 0;
        StringBuilder secondScan = new StringBuilder();
        for(int i = firstScan.length() - 1 ; i >= 0 ; i--) {
            char ch = firstScan.charAt(i);
            if ( ch == ')') {
                right++;
                secondScan.append(')');
            } else if (ch == '(' && left < right) {
                left++;
                secondScan.append('(');
            } else if (ch != ')' && ch != '(') {
                secondScan.append(ch);
            }
        }

        return secondScan.reverse().toString(); 
    }   
}

```



# Find All Solution : Queue + Set
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
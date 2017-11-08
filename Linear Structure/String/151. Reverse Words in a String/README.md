```java
public class Solution {
    public String reverseWords(String s) {
        String[] parts = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for ( int i = parts.length - 1 ; i >=0 ; i-- ){
            sb.append(parts[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
```
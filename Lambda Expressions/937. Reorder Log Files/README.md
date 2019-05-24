```java
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] str1 = log1.split(" ", 2);
            String[] str2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(str1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(str2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int temp = str1[1].compareTo(str2[1]);
                if (temp != 0) return temp;
                return str1[0].compareTo(str2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}
```

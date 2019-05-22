```java
class Solution {
    public List<Integer> partitionLabels(String input) {
        if (input == null || input.length() == 0) return null;
        List<Integer> res = new ArrayList<>();
        int[] lastIndexMap = new int[26];

        for (int i = 0; i < input.length(); i++) {
            lastIndexMap[input.charAt(i)-'a'] = i;
        }
        int end = 0;
        int start = 0;
        for (int i = 0 ; i < input.length() ; i++ ) {
            end = Math.max(end, lastIndexMap[input.charAt(i)-'a']);
            if (end == i) {
                res.add(end-start+1);
                start = end + 1;
            }
        }
        return res;
    }
}
```

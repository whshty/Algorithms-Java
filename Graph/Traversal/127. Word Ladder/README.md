### BFS

### Dual Direction BFS

```java
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(beginWord.equals(endWord)) return 1;
        if (!words.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int count = 1;
        beginSet.add(beginWord); 
        endSet.add(endWord);
        
        return bfs(beginSet,endSet,words,visited,count);
    }
    
    private int bfs(Set<String> beginSet, Set<String> endSet, Set<String> words, Set<String> visited, int count){
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            swapSet(beginSet,endSet);

            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] ch = word.toCharArray();

                for (int i = 0; i < ch.length; i++) {
                    char old = ch[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        ch[i] = c;
                        String tempRes = replace(ch,i,c);

                        if (endSet.contains(tempRes)) return count + 1;
                        if (!visited.contains(tempRes) && words.contains(tempRes)) {
                            temp.add(tempRes);
                            visited.add(tempRes);
                        }
                        ch[i] = old;
                    }
                }
            }
            beginSet = temp;
            count++;
        }
        return 0;
    }
    
    
    private void swapSet(Set<String> beginSet, Set<String> endSet){
        if (beginSet.size() > endSet.size()) {
            Set<String> temp = beginSet;
            beginSet = endSet;
            endSet = temp;
        }
    }
    
    private String replace(char[] ch, int i , char c ){
        ch[i] = c;
        return new String(ch);
    }
}
```
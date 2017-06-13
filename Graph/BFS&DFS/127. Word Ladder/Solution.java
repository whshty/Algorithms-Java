public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if( beginWord == null || endWord == null || wordList == null || wordList.size() == 0 ) return 0;
        return helper(beginWord,endWord,wordList);
    }
    public int helper(String beginWord, String endWord, List<String> wordList){
        int steps = 0;
        Set<String> visited = new HashSet<String>();
        Set<String> begin = new HashSet<String>();
        Set<String> end = new HashSet<String>();
        visited.add(beginWord);
        visited.add(endWord);
        begin.add(beginWord);
        end.add(endWord);
        
        while( !begin.isEmpty() && !end.isEmpty()){
            steps++;
            swapSet(begin,end);
            Set<String> nextLevel = new HashSet<String>();
            
            for(String curStr : begin ){
                for( int i = 0 ; i < curStr.length() ; i++ ){
                    for( char j = 'a' ; j <= 'z' ; j++ ){
                        String toCheck = replace(curStr,i,j);
                        if( end.contains(toCheck)) return steps+1;
                        if( wordList.contains(toCheck) && visited.add(toCheck)){
                            nextLevel.add(toCheck);
                        }
                    }
                }
            }
            begin = nextLevel;
        }
        return 0; 
    }
    
    private void swapSet(Set<String> beginSet, Set<String> endSet){
        if(beginSet.size() > endSet.size()){
            Set<String> temp = beginSet;
            beginSet = endSet;
            endSet = temp;
        } else {
            return;
        }
    }
    
    private String replace(String str, int i , char c ){
        char[] chs = str.toCharArray();
        chs[i] = c;
        return new String(chs);
    }
}
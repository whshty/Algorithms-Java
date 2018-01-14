class Solution {
    public String shortestCompletingWord(String license, String[] words) {
        String str = license.toLowerCase();
        int[] freq = new int[26];
        for( int i = 0 ; i < str.length() ; i++ ){
            if(Character.isLetter(str.charAt(i))) freq[str.charAt(i)-'a']++;
        }
        int minLen = Integer.MAX_VALUE;
        String res = null;
        for( int i = 0 ; i < words.length ; i++ ){
            String word = words[i].toLowerCase();
            if(isMatch(word,freq) && word.length() < minLen){
                minLen = word.length();
                res = words[i];
            }
        }
        return res;
    }
    private boolean isMatch(String word, int[] freq){
        int[] target = new int[26];
        for( int i = 0 ; i < word.length() ; i++ ) {
            if( Character.isLetter(word.charAt(i))) target[word.charAt(i)-'a']++;
        }
        for( int i = 0 ; i < 26 ; i++ ){
            if( freq[i] != 0 && target[i] < freq[i] ) return false;
        }
        return true;
    }
}

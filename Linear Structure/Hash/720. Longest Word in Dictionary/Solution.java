class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";
        for ( String word : words ){
            if( word.length() == 1 || set.contains(word.substring(0,word.length() - 1 ))){
                res = res.length() >= word.length() ? res : word;
                set.add(word);
            }
        }
        return res;
    }
}
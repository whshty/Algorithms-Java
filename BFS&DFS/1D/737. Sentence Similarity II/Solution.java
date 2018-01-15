class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if( words1.length != words2.length ) return false;
        Map<String,String> map = new HashMap<>();
        
        for( String[] pair : pairs ){
            String str1 = dfs(map,pair[0]) , str2 = dfs(map,pair[1]);
            if( !str1.equals(str2)) map.put(str1,str2);
        }
        for( int i = 0 ; i < words1.length ; i++ ){
            if( !words1[i].equals(words2[i]) && !dfs(map,words1[i]).equals(dfs(map,words2[i]))) return false;
        }
        return true;
        
    }
    private String dfs(Map<String,String> map , String str){
        if( !map.containsKey(str) ) map.put(str,str);
        return str.equals(map.get(str)) ? str : dfs(map,map.get(str));
    }
}
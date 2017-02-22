public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return isMatch(str, 0, pattern, 0, map, set);
    }
    public boolean isMatch(String str, int i , String pattern, int j , Map<Character,String> map , Set<String> set ){
        if( i == str.length() && j == pattern.length() ) return true;
        if( i == str.length() || j == pattern.length() ) return false;
        
        char ch = pattern.charAt(j);
        
        if( map.containsKey(ch)){
            String s = map.get(ch);
            if( !str.startsWith(s,i)){
                return false;
            }
            // if match, continue to match the rest
            return isMatch(str,i+s.length(),pattern,j+1,map,set);
        }
        // pattern does not exist in the map
        for( int k = i ; k < str.length() ; k++ ){
            String p = str.substring(i,k+1);
            if( set.contains(p)){
                continue;
            }
            map.put(ch,p);
            set.add(p);
            if( isMatch(str,k+1,pattern,j+1,map,set)){
                return true;
            }
            
            map.remove(ch);
            set.remove(p);
        }
        return false;
    }
}
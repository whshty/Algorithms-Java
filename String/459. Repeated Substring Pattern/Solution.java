public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if( len < 2 ) return false;
        for(int i=1;i<=len;i++){
            if(len%i != 0) continue;
            if(isValid(s,i)) return true;
        }
        return false;
        
    }
    public boolean isValid(String str,int pos){
        int len = str.length();
        if( pos >= len ) return false;
        String sub = str.substring(0,pos);
        for( int i = 0 ; i < len ; i++ ){
            if( str.charAt(i) != sub.charAt(i%(pos))) return false;
        }
        return true;
        
    }
}
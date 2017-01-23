public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(s , 0 , res , list );
        return res;
    }
    public void helper( String s , int pos , List<List<String>> res, List<String> list){
        if( pos == s.length() ) {
            res.add( new ArrayList<String>(list) );
        } else {
            for( int i = pos ; i < s.length(); i++ ){
                if( isPalindrome(s , pos , i) ){
                    list.add(s.substring(pos,i+1));
                    helper( s , i+1 , res , list);
                    list.remove( list.size() - 1 );
                }
            }
        }
    }
    public boolean isPalindrome( String s , int low , int high){
        while( low < high ){
            if( s.charAt(low) != s.charAt(high) ) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
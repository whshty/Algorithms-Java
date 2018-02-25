class Solution {
    public String boldWords(String[] words, String s) {
        if( words == null || words.length == 0 ) return "";
        
        boolean[] isBold = new boolean[s.length()];
        for( int i = 0 ; i < words.length ; i++ ){
            markBold(s,words[i],isBold);
        }
        StringBuilder sb = new StringBuilder();
        for( int i = 0 ; i < s.length() ; i++ ){
            if( isBold[i] && (i == 0 || !isBold[i-1])){
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if(isBold[i] && ( i == s.length() - 1 || !isBold[i+1])){
                sb.append("</b>");    
            }
            
        }
        return sb.toString();
            
    }
    
    private void markBold(String s, String word, boolean[] isBold){
        for( int i = 0 ; i <= s.length() - word.length() ; i++ ){
            String sub = s.substring(i,i+word.length());
            if(word.equals(sub)){
                for( int j = i ; j < i + word.length() ; j++ ){
                    isBold[j] = true;
                }
            }
        }
    }
}
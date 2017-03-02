public class Solution {
    public List<String> fullJustify(String[] words, int max) {
        List<String> res = new ArrayList<>();
        int curWord = 0;
        while ( curWord < words.length){
            int curLength = words[curWord].length();
            int nextWord = curWord + 1;
            // calculate how many words can be put in this line
            while( nextWord < words.length){
                if ( words[nextWord].length() + curLength + 1 > max) break;
                curLength += words[nextWord].length() + 1;
                nextWord++;
            }
            StringBuilder  sb = new StringBuilder();
            int diff = nextWord - curWord - 1;
            // left - justified , for last line
            if( nextWord ==  words.length || diff == 0){
                for(int i = curWord; i < nextWord ; i++){
                    sb.append(words[i]+" ");
                }
                sb.deleteCharAt(sb.length() - 1 );
                for( int i = sb.length() ; i < max ; i++){
                    sb.append(" ");
                }
            } else {
                 // middle
                int space = ( max - curLength ) / diff; // equally divided space
                int right = ( max - curLength ) % diff;
                for( int i = curWord ; i < nextWord ; i++){
                    sb.append(words[i]);
                    if( i < nextWord - 1){
                        
                        if( (i -  curWord) < right){
                            for( int j  = 0 ; j <= space + 1 ; j++ ){
                                sb.append(" ");
                            }
                        } else {
                            for( int j = 0  ;  j <= space ; j++ ){
                                sb.append(" ");
                            }
                        }
                    }
                }
            }
            res.add(sb.toString());
            curWord = nextWord;
        }
        return res;
    }
}
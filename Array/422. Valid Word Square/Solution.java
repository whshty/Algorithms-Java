public class Solution {
    public boolean validWordSquare(List<String> words) {
        int row = words.size();
        for( int i= 0 ; i < row ; i++ ){
            for( int j = 0 ; j < words.get(i).length() ; j++ ){
                if( j >= row || words.get(j).length() <= i || words.get(i).charAt(j) != words.get(j).charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
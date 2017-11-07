## 1.BFS
* If you use BFS, you have to record the positions visited for each path, which can get Time Limit Exceeded.

## 2.DFS
* Time O(m * n * 4^k)

```java
public class Solution {
    public boolean exist(char[][] board, String word) {
        for( int i = 0 ; i < board.length ; i++ ){
            for( int j = 0 ; j < board[0].length ; j++ ){
                if( dfs( board, i , j , word , 0 ) ) return true;   
            }
        }
        return false;
    }
    public boolean dfs( char[][] board, int x , int y , String word, int pos){
        if( pos == word.length() ) return true;
        if( x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if( board[x][y] == word.charAt(pos) ){
            char temp = board[x][y];
            board[x][y] = '*';
            pos++;
            boolean res = dfs(board,x+1,y,word,pos) ||
                          dfs(board,x-1,y,word,pos) ||
                          dfs(board,x,y+1,word,pos) ||
                          dfs(board,x,y-1,word,pos);
            board[x][y] = temp;
            return res;
        } 
        return false;
        
    }
}
```
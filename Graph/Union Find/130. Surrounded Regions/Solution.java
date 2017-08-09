public class Solution {
    private int[] ids;
    private int[] sizes;
        
    private int oEdge;
    int m;
    int n;
    public void solve(char[][] board) {
        if((m = board.length) == 0 || (n = board[0].length) == 0) return;
        ids = new int[m*n];
        sizes = new int[m*n];
        Arrays.fill(sizes,1);
        oEdge = -1;
      
        for( int i = 0 ; i < m ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                if( board[i][j] == 'X') continue;
                // board[i][j] == 'O'
                int index = i*n + j;
                ids[index] = index;
                if( i == 0 || j == 0 || i == m -1 || j == n - 1 ){
                    // set index for the first time
                    if( oEdge == - 1){
                        oEdge = index;
                    } else {
                        // unite it with index 
                        unite(oEdge,index);
                    }
                }
                // to upper part
                if( i > 0 && board[i-1][j] == 'O'){
                    unite(index,index-n);
                }
                // to left part
                if( j > 0 && board[i][j-1] == 'O'){
                    unite(index,index-1);
                }
            }
        }
        // generate new board
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'X') {
                    continue;
                }
                int index = i * n + j;
                if (oEdge == -1 || !find(index, oEdge)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void unite(int a, int b){
        int i = findRoot(a);
        int j = findRoot(b);

        if (sizes[i] < sizes[j]) {
            ids[i] = j;
            sizes[j] += sizes[i];
        } else {
            ids[j] = i;
            sizes[i] += sizes[j];
        }
    }

    private boolean find(int a, int b){
        return findRoot(a) == findRoot(b);
    }

    private int findRoot(int i) {
        while (i != ids[i]) {
            // Path compression
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }
}
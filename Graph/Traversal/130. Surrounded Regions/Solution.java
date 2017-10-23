public class Solution {
    
    int[] unionSet; // union find set
    boolean[] hasEdgeO; // whether an union has an 'O' which is on the edge of the matrix
    
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;

        // init, every char itself is an union
        int m = board.length, n = board[0].length;
        int size = m * n;
        unionSet = new int[size];
        hasEdgeO = new boolean[size];
        for(int i = 0 ; i < size ; i++) {
            unionSet[i] = i;
        }    
        for(int i = 0 ; i < size ; i++){
            int x = i / n, y = i % n;
            hasEdgeO[i] = (board[x][y] == 'O' && ( x == 0 || x == m - 1 || y == 0 || y == n-1));
        }
        
        // union it + its upper char + its right char if they equals to each other
        for(int i = 0 ; i < size ; i++){
            int x = i / n, y = i % n, up = x - 1, right = y + 1;
            if( up >= 0 && board[x][y] == board[up][y]) union(i,i-n);
            if( right < n && board[x][y] == board[x][right]) union(i,i+1);
        }
        
        //if it is an 'O' and its union doesn't has an 'edge O', the whole union should be setted as 'X'
        for(int i = 0 ; i < size ; i++){
            int x = i / n, y = i % n;
            if( board[x][y] == 'O' && !hasEdgeO[findSet(i)]) board[x][y] = 'X'; 
        }
    }
    
    private void union(int x,int y){
        int rootX = findSet(x);
        int rootY = findSet(y);
        // if there is an union has an 'edge O',the union after merge should be marked too
        boolean flag = hasEdgeO[rootX] || hasEdgeO[rootY];
        unionSet[rootX] = rootY;
        hasEdgeO[rootY] = flag;
    }
    
    private int findSet(int x){
        if(unionSet[x] == x) return x;
        unionSet[x] = findSet(unionSet[x]);
        return unionSet[x];
    }
}
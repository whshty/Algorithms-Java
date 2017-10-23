public class Solution {
    public int shortestDistance(int[][] grid) {
        if( grid == null || grid[0].length == 0) return 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = grid.length, col = grid[0].length;
        int[][] distance = new int[row][col];
        int[][] reachNum = new int[row][col];        
        int buildingNum = 0;
        
        for( int i = 0 ; i < row ; i++ ){
            for( int j = 0 ; j < col ; j++ ){
                if(grid[i][j] == 1){
                    buildingNum++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i,j});
                    boolean[][] isVisited = new boolean[row][col];
                    int step = 1;
                    while(!queue.isEmpty()){
                        int size = queue.size();
                        for( int q = 0 ; q < size ; q++){
                            int[] cur = queue.poll();
                            for(int[] dir : dirs){
                                int indexX = cur[0] + dir[0];
                                int indexY = cur[1] + dir[1];
                                if(isValid(indexX,indexY,row,col) && grid[indexX][indexY] == 2) continue;
                                if(isValid(indexX,indexY,row,col) && grid[indexX][indexY] == 0 && !isVisited[indexX][indexY]){
                                    // distance is the sum of shortese distance from this block to all reachable buildings
                                    distance[indexX][indexY] += step;
                                    // count how may building each '0' has reached
                                    reachNum[indexX][indexY]++;
                                    isVisited[indexX][indexY] = true;
                                    queue.offer(new int[]{indexX,indexY});
                                }
                            }
                        }
                        // first level 1 , 1 step, second level 2 step .....
                        step++;
                    }
                }
            }
        }
        int shortestVal = Integer.MAX_VALUE;
        for( int i = 0 ; i < row ; i++ ){
            for( int j = 0 ; j < col ; j++ ){
                if( grid[i][j] == 0 && reachNum[i][j] == buildingNum){
                    shortestVal = Math.min(shortestVal, distance[i][j]);
                }
            }
        }
        return shortestVal == Integer.MAX_VALUE ? -1 : shortestVal;
    }
    
    private boolean isValid( int x , int y , int row , int col){
        return x >=0 && x < row && y >= 0 && y < col;
    }
}
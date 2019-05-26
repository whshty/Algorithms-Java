import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    private final static int[] dirX = {-1, 0, 0, 1};
    private final static int[] dirY = {0, 1, -1, 0};

    public static void main(String[] args) {
        Maze maze = new Maze();

        int[][] input = {
                {1,0,0,0,0},
                {1,1,1,1,1},
                {1,0,0,0,0},
                {0,0,9,0,0}};

        System.out.println(maze.traverse(input));

        int[][] input2 = {
                {1,0,0,0,0},
                {1,1,1,1,1},
                {1,0,0,0,1},
                {0,0,9,1,1}};

        System.out.println(maze.traverse(input2));

        int[][] input3 = {
                {1,1,1,1},
                {1,0,0,0},
                {1,9,0,0}};
        System.out.println(maze.traverse(input3));

        int[][] input4 = {
                {1,1,1,1,1,1},
                {1,1,1,1,0,0},
                {0,0,1,0,0,0},
                {1,1,1,1,1,1},
                {1,0,0,0,1,0},
                {1,1,1,0,9,0}};
        System.out.println(maze.traverse(input4));
    }


    public int traverse(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        if (matrix[0][0] == 9) return 1;
        int row = matrix.length, col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        matrix[0][0] = -1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tempX = cur[0] + dirX[i];
                int tempY = cur[1] + dirY[i];
                if (tempX >= 0 && tempX < row && tempY >= 0 && tempY < col) {
                    if (matrix[tempX][tempY] == -1) continue;
                    if (matrix[tempX][tempY] == 9) return 1;
                    else if (matrix[tempX][tempY] == 1) {
                        queue.offer(new int[]{tempX,tempY});
                        matrix[tempX][tempY] = -1;
                    }
                }
            }
        }
        // Didn't find
        return 0;
    }
}


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {

    }

    public boolean bfs(int[][] map, int initX, int initY) {

        if (map == null || map.length == 0 || map[0].length == 0) return false;

        int width = map[0].length;
        int height = map.length;

        Queue<Position> queue = new LinkedList<>();
        Position start = new Position(initX, initY, map[initX][initY]);
        queue.offer(start);

        Position temp = queue.poll();

        while (temp.value != 9) {
            int x = temp.x;
            int y = temp.y;
            // Marked as visited
            map[x][y] = 1;
            if ((x + 1) < height) {
                if (map[x + 1][y] > 0) {
                    queue.offer(new Position(x + 1, y, map[x + 1][y]));
                }
            }
            if ((x - 1) >= 0) {
                if (map[x - 1][y] > 0) {
                    queue.offer(new Position(x - 1, y, map[x - 1][y]));
                }
            }
            if ((y + 1) < width)
                if (map[x][(y + 1)] > 0) {
                    queue.offer(new Position(x, (y + 1), map[x][(y + 1)]));
                }

            if ((y - 1) >= 0)
                if (map[x][(y - 1)] > 0) {
                    queue.offer(new Position(x, (y - 1), map[x][(y - 1)]));
                }

            if (queue.isEmpty()) {
                break;
            } else
                temp = queue.poll();


        }
        return temp.value == 9;
    }
}

class Position {
    int x;
    int y;
    int value;

    Position(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}




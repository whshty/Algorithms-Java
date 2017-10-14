### BFS + Color Array
```java
class Solution {
    // public static void main(String[] args) {
    //     int input[][] = {{0, 1, 0, 1},
    //             {1, 0, 1, 0},
    //             {0, 1, 0, 1},
    //             {1, 0, 1, 0}};
    //     System.out.println(isBipartiteGraph(input));

    // }
    public static boolean isBipartiteGraph(int[][] input) {
        int len = input.length;
        int[] arr = new int[len]; // color array, two colors 0 and 1
        Arrays.fill(arr, -1);

        arr[0] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (input[node][node] == 1) return false; // node is self connected

            for (int i = 0; i < len; i++) {
                // if i and node is connected but node i is not coloured
                if (input[node][i] == 1 && arr[i] == -1) {
                    arr[i] = 1 - arr[node];
                    queue.add(i);
                }
                // connected but same color
                else if (input[node][i] == 1 && arr[i] == arr[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
```
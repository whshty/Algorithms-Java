```java
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || k > points.length) return new int[0][0];

        Queue<int[]> minHeap = new PriorityQueue<int[]>((p, q) -> (int) ((Math.pow(p[0],2) + Math.pow(p[1],2)) - (Math.pow(q[0], 2) + Math.pow(q[1],2))));


        Arrays.asList(points).stream().forEach(point -> minHeap.add(point));

        int[][] result = new int[k][2];
        for( int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
```

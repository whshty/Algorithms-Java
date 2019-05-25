class Solution {
  public static void main(String[] args) {
    System.out.println("test");
    Solution solution = new Solution();
    int[][] AllLocations = new int[][]{
      {1,2},{3,4},{1,-1}
    };
    int numDestinations = 3;
    int numDeliveries = 2;
    int[][] res = solution.helper(numDestinations, AllLocations, numDeliveries);
    
    
    for(int[] i : res ){
      System.out.println(i[0] + " " + i[1]);
    }
    
  }
  
  public int[][] helper(int numDestinations, int[][] allLocations, int numDeliveries) {
    if (allLocations== null || numDestinations > allLocations.length) return new int[0][0];

    Queue<int[]> minHeap = new PriorityQueue<int[]>(
      (p, q) -> (int) ((Math.pow(p[0],2) + Math.pow(p[1],2)) - (Math.pow(q[0], 2) + Math.pow(q[1],2)))
    );


    Arrays.asList(allLocations).stream().forEach(location -> minHeap.add(location));

    int[][] result = new int[numDeliveries][2];
    for( int i = 0; i < numDeliveries; i++) {
        result[i] = minHeap.poll();
    }
    return result;
  }
}

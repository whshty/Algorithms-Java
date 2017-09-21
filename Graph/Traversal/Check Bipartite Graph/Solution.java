class myCode {
    public static void main (String[] args) throws java.lang.Exception {
         int input[][] = {{0, 1, 0, 1},
                          {1, 0, 1, 0},
                          {0, 1, 0, 1},
                          {1, 0, 1, 0}};
        System.out.println(isBipartiteGraph(input));
        
    }
    
    public static boolean isBipartiteGraph(int[][] input){
        int verticeNum = input.length;
        int[] arr = new int[verticeNum];
        Arrays.fill(arr,-1);
        
        arr[0] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(input[node][node] == 1) return false;
            
            for(int i = 0 ; i < verticeNum; i++ ){
                if(input[node][i] == 1 && arr[i] == -1 ){
                    arr[i] = 1 - arr[node];
                    queue.add(i);
                } else if (input[node][i] == 1 && arr[i] == arr[node]) return false;
            }
        }
        return true;
    }
}

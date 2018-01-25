class Solution {
    public boolean judgePoint24(int[] nums) {
        boolean[] visited = new boolean[4];
        double[] arr = new double[4];
        for( int i = 0 ; i < 4 ; i++ ){
            arr[i] = 1.0 * nums[i];
        }
        return dfs(arr,visited,4);
    }
    private boolean dfs(double[] arr, boolean[] visited , int count ){
        double pre = 0;
        if( count == 1 ){
            for( int i = 0 ; i < arr.length ; i++ ){
                if(!visited[i]) return Math.abs(arr[i]-24) < 0.000001 ? true : false;
            }
        }
        for( int i = 0 ; i < arr.length ; i++ ){
            if( visited[i] ) continue;
            pre = arr[i];

            for( int j = i + 1 ; j < arr.length ; j++ ){
                if( visited[j] ) continue;
                visited[j] = true;

                // add
                arr[i] = pre + arr[j];
                if (dfs(arr, visited, count - 1 )) return true;

                // minus
                arr[i] = pre - arr[j];
                if (dfs(arr, visited, count - 1)) return true;
                arr[i] = -pre + arr[j];
                if (dfs(arr, visited, count - 1)) return true;

                // multiply
                arr[i] = pre * arr[j];
                if (dfs(arr, visited, count - 1 )) return true;

                // division
                arr[i] = pre / arr[j];
                if (dfs(arr, visited, count - 1 )) return true;
                arr[i] = arr[j] / pre;
                if (dfs(arr, visited, count - 1 )) return true;
                visited[j] = false;
            }
            arr[i] = pre;
        }
        return false;
    }
}

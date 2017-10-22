public class Solution {
    public int[] findLeftMostOne(int[][] matrix){
        int[] res = new int[2];

        int leftMost = binarySearch(matrix[0],0,matrix[0].length);
        res[1] = leftMost;

        for ( int i = 1 ; i < matrix.length ; i++ ){
            if(matrix[i][leftMost] == 0 ) continue;
            else{
                leftMost = binarySearch(matrix[i],0,leftMost);
                res[0] = i;
                res[1] = leftMost;
            }
        }

        return res;

    }

    public int binarySearch(int[] nums, int start , int end ){
        while( start < end ){
            int mid = (start + end ) >>> 1;
            if( nums[mid] == 0 ){
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
}


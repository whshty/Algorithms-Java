public class Solution {
    public int[][] generateMatrix(int n) {
    	if (n <= 0 ) return new int[0][0];

    	int[] cur = new int[]{1};
    	int[][] res = new int[n][n];
    	helper(res, cur, n , 0);
    	return res;
    }

   	private void helper (int[][] res, int[] val, int size, int offset){
   		//Base case
   		if (size == 0) return;
   		if (size == 1){
   			res[offset][offset] = val[0]++;
   			return;
   		}

   		//first row 
   		for(int i = offset; i < size - 1 + offset; i++) {
            res[offset][i] = val[0]++;
        }

   		//right row 
   	    for(int i = offset; i < size - 1 + offset; i++) {
            res[i][size - 1 + offset] = val[0]++;
        }
   		//last row 
   		for (int i = size - 1 + offset; i > offset ; i--){
   			res[size - 1 + offset][i] = val[0]++;
   		}
   		// left row 
   		for (int i = size - 1 + offset ; i > offset ; i--){
   			res[i][offset]  = val[0]++;
   		}

   		//next level
   		helper(res, val , size - 2 , offset + 1);
   	}
}
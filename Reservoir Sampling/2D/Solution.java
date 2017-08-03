import java.io.*;
import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        
        int[][] res = generateRandomMatrix(10,8,3);
        for( int i = 0 ; i < res.length ; i ++ ){
            for( int j = 0 ; j < res[0].length ; j++ ){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
    private static int[][] generateRandomMatrix(int h , int w , int k){
        int[][] res = new int[h][w];
        int size = h * w;
        
        // key  : 0 ~ k - 1
        // value : pos
        Map<Integer,Integer> map = new HashMap<>();
        
        for( int i = 0 ; i < h ; i++ ){
            for( int j = 0 ; j < w ; j++ ){
                int index = i * w + j; 
                if( index < k){
                    res[i][j] = 1;
                    map.put(index,index);
                } else {
                    int ran = new Random().nextInt(index);
                    if( ran < k ){
                        int m = map.get(ran)/w; 
                        int n = map.get(ran)%w;
                        res[m][n] = 0;
                        res[i][j] = 1;
                        map.put(ran,i*w+j);
                        
                    }
                }
            }
        }
        return res;
    }
}

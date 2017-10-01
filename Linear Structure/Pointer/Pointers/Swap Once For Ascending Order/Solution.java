import java.io.*;
import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        int[] nums = new int[]{1,2,6,4,5,3};
        System.out.println(checkSortedArray(nums));
    }
    
    
    public static boolean checkSortedArray(int[] nums){
        if( nums == null) return false;   
        
        for( int i = nums.length - 1; i > 0 ; i-- ){
            if( nums[i] < nums[i-1]){
                int j = i - 1;
                while( j >= 0 && nums[i] < nums[j]) j--;  
                swap(nums,i,j+1);
                break;
            }
        }      
        return true;
    }
    public static void swap(int[] nums , int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}



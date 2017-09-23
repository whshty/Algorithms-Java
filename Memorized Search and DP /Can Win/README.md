### Can Win

```
import java.io.*;
import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        int[] input = new int[]{2,3,0,3,5};
        boolean res = canWin(input,3);
        
        System.out.println(res);

    }
    public static boolean canWin(int[] nums, int index){
        Map<Integer,Boolean> map = new HashMap<>();
        return helper(nums,map,index);
        
    }
    public static boolean helper(int[] nums, Map<Integer,Boolean> map, int index){
        
        if( map.containsKey(nums[index])) return map.get(index);
        if( nums[index] == 0 ) return true;
        else{
            //System.out.println(index-nums[index]-1);
            boolean left = false, right = false;
            if( index-nums[index] >= 0 ) {
                
                left = helper(nums,map,index-nums[index]);
            }
            if( index+nums[index] < nums.length )  right = helper(nums,map,index+nums[index]);
            map.put(index,(left||right));
        }
        return map.get(index);
    
        
        
    }

}

```
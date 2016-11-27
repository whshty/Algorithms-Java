// brute force
// two pass 
// O(n) * 2 = o(n)
public class Solution {
    public void sortColors(int[] nums) {
        int[] set = new int[3];
        set[0] = 0;
        set[1] = 0;
        set[2] = 0;
        for(int i : nums){
            set[i] +=1;
        }
        int index = 0;
        for(int i = 0 ; i < 3 ; i++ ){
            while(set[i] > 0 && index < nums.length ){
                nums[index] = i;
                index++;
                set[i]--;
            }
        }      
    }
}
// two pointers
// one pass 
public class Solution {
    public void sortColors(int[] nums) {
        if( nums == null || nums.length <= 1) return;
        // left : first wall , the end of 0
        // right : second wall , the start of 2 
        // cur : scanner for unprocessed data
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        while(cur < nums.length - 1){
            if(nums[cur] == 0) swap(nums,cur++,left++);
            else if(nums[cur] == 2) swap(nums,cur,right--);
            else cur++;
        }
    }
    private void swap(int[] nums, int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
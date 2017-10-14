### Use Pointers

* left : first wall , the end of 0
* right : second wall , the start of 2 
* cur : scanner for unprocessed data

```java
public class Solution {
    public void sortColors(int[] nums) {
        if( nums == null || nums.length <= 1) return;
        int left = 0;
        int cur = 0;
        int right = nums.length-1;
        
        while( cur <= right ){
            if( nums[cur] == 1 ) cur++;
            else if( nums[cur] == 0 ) swap(nums,left++,cur++);
            else if( nums[cur] == 2 ) swap(nums,cur,right--);
        }
    }
    private void swap(int[] nums, int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;   
    }
}
```

### Use HashMap 

* Use hashmap to maintain the frequency of 0, 1, 2
* Generate a new array by frequency 


### Follow-Up ( Sort K Colors)

```java
public void sortKCategory(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        int min = 1, max = k;
        while (min < max) {
            while (cur <= right) {
                if (getCat(nums[cur]) == min) {
                    swap(nums, left, cur);
                    cur++;
                    left++;
                } else if (getCat(nums[cur]) == max) {
                    swap(nums, right, cur);
                    right--;
                } else {
                    cur++;
                }
            }
            cur = left;
            min++;
            max--;
        }
    }
```
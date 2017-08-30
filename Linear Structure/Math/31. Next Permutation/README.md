# 31. Next Permutation

## Idea
* Find two closed elemennt from the end
* If we find the previous is smaller than the second
* Then, we start from the end again, find the first number that is bigger than pevious, and swap the number and previous
* and sort every number after "second", second is included 

```
6, 3 , 4, 9 , 8 , 7 , 1 

previous = 4 , second = 9 
then we found 7 and swap
6 3 7 9 8 4 1
sort 9  8 4 1 , the order is descending for sure
So the result is
6 3 7 1 4 8 9 

```

## Time & Space 
* O(n) & O(1)

## Code

```
public class Solution{
	public void nextPermutation(int[] nums){
		// corner case
		if(nums.length<=1) return;
        // i - 1 : first , i : second
	    int second = 0;
		for( int i = nums.length - 1; i>=1 ;i--){
			if(nums[i] > nums[i-1]) {
                second = i;
                break;
            }
		}
		if(second!=0) swap(nums,second-1);
		reverse(nums,second);
	}
    private void swap(int[] nums,int i){
        for(int j = nums.length-1;j>i;j--){
            if( nums[j] > nums[i] ){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                break;
            }
        }
    }
    //reverse the number after the number we have found
    //the orignal order is descending for sure
    private void reverse(int[] nums,int i){
        int first = i;
        int last = nums.length-1;
        while(first<last){
            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
            first ++;
            last --;
        }
    }
}

```

## Follow - Up (Previous Permutaion)

## Idea 
* Change < to > 
* Change > to < 


```
1 , 3 , 2 , 3 
previous = 3 , second = 2 
then we found 2  and swap
1 , 2 , 3 ,3
sort 3 ,3 
The final result is 1 , 2 , 3 ,3

```


## Code

```
import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(3);
        test.add(2);
        test.add(3);

        myCode sol = new myCode();
        List<Integer> res = sol.previousPermutation(test);
        for( int i : res){
            System.out.print(i);
        }
    }
    public List<Integer> previousPermutation(List<Integer> n){
        // corner case
        List<Integer> nums = new ArrayList<>(n);
        if(nums.size()<=1) return nums;
        int i = nums.size() - 1;
        for( ; i>=1 ;i--){
            if(nums.get(i) < nums.get(i-1)) break;
        }
        if(i!=0) swap(nums,i-1);
        reverse(nums,i);
        return nums;
    }
    private void swap(List<Integer> a,int i){
        for(int j = a.size()-1;j>i;j--){
            if(a.get(j)<a.get(i)){
                int temp = a.get(j);
                a.set(j,a.get(i));
                a.set(i,temp);

                break;
            }
        }
    }
    //reverse the number after the number we have found
    //the orignal order is descending for sure
    private void reverse(List<Integer> a,int i){
        int first = i;
        int last = a.size()-1;
        while(first<last){
            int temp = a.get(first);
            a.set(first,a.get(last));
            a.set(last,temp);
            first ++;
            last --;
        }
    }
}

```
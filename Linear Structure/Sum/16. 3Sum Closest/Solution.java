// 1.sort an input array
// 2 run through all indices of a possible first element of  triplet
// 3.for each possible first element, make a standard bi-directional sweep   for the remaining part
// 4.skip equal elements to avoid duplicateds
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int res = num[0] + num[1] + num[num.length-1];
        for( int i = 0 ; i < num.length - 2 ; i++ ){
            int start = i + 1;
            int end = num.length - 1;
            while( start < end ){
                int sum = num[i] + num[start] + num[end];
                if( sum > target) end--;
                else start++;
                if( Math.abs(sum-target) < Math.abs(res-target)){
                    res = sum;
                }
            }
        }
        return res;
    }
}
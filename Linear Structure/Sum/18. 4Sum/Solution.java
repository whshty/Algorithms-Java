public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if( num.length < 4 ) return res;
        Arrays.sort(num);
        for(int i = 0 ; i < num.length - 3 ; i++){
            if( i > 0 && num[i] == num[i-1]) continue;
            for(int j = i+1 ; j < num.length - 2 ; j++){
                if( j > i + 1 && num [j] == num[j-1] ) continue;
                int start = j + 1 , end = num.length - 1;
                while( start < end ){
                    int sum = num[i] + num[j] + num[start] + num[end];
                    if( sum == target){
                        res.add(Arrays.asList(num[i], num[j], num[start], num[end]));
                        while(start < end && num[start] == num[start+1]) start++;
                        while(start < end && num[end] == num[end-1]) end--;
                        start++;
                        end--;
                    }
                    else if( sum < target) start++;
                    else end--;
                }
            }
        }
        return res;
    }
}
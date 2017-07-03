public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if( nums == null || nums.length == 0 ) return res;
        dfs(nums,res,0);
        return res;
    }
    
    private void dfs(int[] nums, List<List<Integer>> res, int pos){
        if( pos == nums.length ){
            List<Integer> list = new ArrayList<>();
            for( int num : nums ){
                list.add(num);
            }
            res.add(list);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for( int i = pos ; i < nums.length ; i++ ){
            if( set.add(nums[i])){
                swap(nums,i,pos);
                dfs(nums,res,pos+1);
                swap(nums,i,pos);
            }
        }
    }
    private void swap(int[] a , int i , int j ){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
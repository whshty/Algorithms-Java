public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] hours = new int[]{8,4,2,1};
        int[] minutes = new int[]{32,16,8,4,2,1};
        
        for( int i = 0 ; i <= num ; i++ ){
            List<Integer> hourList = generateDigit(hours,i);
            List<Integer> minuteList = generateDigit(minutes,num-i);
            for( int hour : hourList ){
                if( hour >= 12 ) continue;
                for( int minute : minuteList ){
                    if( minute >= 60 ) continue;
                    res.add( hour + ":" + ( minute < 10  ? "0" + minute : minute));
                }
            }
        }
        return res;
    }
    private List<Integer> generateDigit(int[] nums, int count ){
        List<Integer> res = new ArrayList<>();
        dfs(nums,count,res,0,0);
        return res;
    }
    
    private void dfs( int[] nums, int count , List<Integer> res, int sum , int pos){
        if( count == 0 ){
            res.add(sum);
            return;
        }
        for( int i = pos; i < nums.length ; i++ ){
            dfs(nums,count-1,res,sum+nums[i],i+1);
        }
    }
}
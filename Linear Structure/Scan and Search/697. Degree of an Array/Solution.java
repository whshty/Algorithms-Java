class Solution {
    public int findShortestSubArray(int[] nums) {
        if( nums == null || nums.length == 0 ) return 0;
        int max = 0;

        // int[] = {start,end,freq}
        Map<Integer,int[]> map = new HashMap<>();
        for( int i = 0 ; i < nums.length ; i++ ){
            map.putIfAbsent(nums[i],new int[]{i,i,1});
            int[] values = map.get(nums[i]);
            values[1] = i;
            values[2]++;
            if( values[2] > max ) max = values[2];
            map.put(nums[i],values);
        }

        int size = nums.length;
        for( Map.Entry<Integer,int[]> entry : map.entrySet() ){
            int[] values = entry.getValue();
            if( values[2] == max ){
                size = Math.min(size,values[1] - values[0] + 1);
            }
        }
        return size;
    }
}

class Solution {
    public int pathSum(int[] nums) {
        if( nums.length == 0 ) return 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for( int num : nums ){
            int level = num / 100;
            int val = num % 10;
            int key = ( num - val ) / 10;
            int pos = ( num % 100 - val ) / 10;
            
            if ( level == 1 ) map.put(11,val);
            else {
                int upperKey = ( level - 1 ) * 10 + ( pos + 1 ) / 2;
                map.put(key,val + map.get(upperKey));
            }
        }
        
        for( int key : map.keySet()){
            int level = key / 10;
            int pos = key % 10;
            int nextLeft = 10 * ( level +1 ) + pos * 2 - 1;
            int nextRight = 10 * ( level + 1) + pos * 2;
            if ( !map.containsKey(nextLeft) && !map.containsKey(nextRight)){
                sum += map.get(key);
            }
        }
        return sum;
         
    }
}
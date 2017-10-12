public class Solution {
    public boolean canPartition(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for( int num : nums ){
            map.put(num,map.getOrDefault(num,0)+1);
            sum += num;
        }
        if( sum % 2 != 0 ) return false;
        
        return dfs(map,sum/2);    
    }
    
    private boolean dfs(Map<Integer,Integer> map, int target){
        if(map.containsKey(target) && map.get(target) > 0 ) return true;
        
        for( int key : map.keySet()){
            if( key < target && map.get(key) > 0 ){
                map.put(key,map.get(key)-1);
                if(dfs(map,target-key)) return true;
                map.put(key,map.get(key)+1);
            }
        }
        return false;   
    }
}
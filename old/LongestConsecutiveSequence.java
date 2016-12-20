// time o(n)
// space o(n)
public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int n : nums){
            if(!map.containsKey(n)){
                int left = (map.containsKey(n-1)) ? map.get(n-1) : 0;
                int right = (map.containsKey(n+1)) ? map.get(n+1) : 0;
                int sum = left + right + 1;
                map.put(n,sum);
                res = Math.max(res,sum); 
                // extend the length to the boundarys
                map.put(n-left,sum);
                map.put(n+right,sum);
            }
        }
        return res;
    }
}
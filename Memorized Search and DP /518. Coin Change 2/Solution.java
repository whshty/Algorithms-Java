class Solution {
    public int change(int amount, int[] coins) {
        if( coins == null || coins.length == 0 && amount == 0 ) return 1;
        return helper(coins,0,amount, new HashMap<Integer,Integer>);
    }
    public int helper(int[] nums, int pos , int amount, Map<Integer,Integer> map){
        int res = 0;
        if( amount < 0 ) return 0;
        if( amount == 0 ) return 1;
        for( int i = pos ; i < nums.length ; i++ ){
            res += helper(nums,i,amount-nums[i]);
        }
        return res;
    }
}


class Solution {
    public int change(int amount, int[] coins) {
        if( coins == null || coins.length == 0 && amount == 0 ) return 1;
        return helper(coins,0,amount, new HashMap<Node,Integer>());
    }
    public int helper(int[] nums, int pos , int amount, Map<Node,Integer> map){
        if( amount < 0 ) return 0;
        if( amount == 0 ) return 1;
        Node temp = new Node(amount,pos);
        if( map.containsKey(temp)) return map.get(amount);
        
        int res = 0;
        for( int i = pos ; i < nums.length ; i++ ){
            res += helper(nums,i,amount-nums[i],map);
        }
        map.put(new Node(amount,pos),res);
        return res;
    }
}

class Node {
    int pos;
    int amount;
    Node(int p, int a){
        pos = p;
        amount = a;
    }
}
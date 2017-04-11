public class NumArray {
    int[] tree;
    int[] nums;
    int size;
    
    public NumArray(int[] nums) {
        this.size = nums.length;
        this.tree = new int[size+1];
        this.nums = new int[size];
        this.nums = nums;
        for( int i = 0 ; i < size ; i++ ){
            updateTree(i,nums[i]);
        }
    }
    
    public void updateTree( int i , int val ){
        i = i + 1;
        while( i <= size ){
            tree[i] += val;
            i += i & (-i);
        }    
    }
    
    public void update(int i, int val) {
        updateTree(i,val-nums[i]);
        nums[i] = val;
    }
    
    public int getSum(int i ){
        int sum = 0;
        i = i + 1 ;
        while( i > 0 ){
            sum += tree[i];
            i -= i & ( -i );
        }
        return sum;
    }
    
    public int sumRange(int i, int j) {
        if( i == 0 ) return getSum(j);
        else return getSum(j) - getSum(i-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
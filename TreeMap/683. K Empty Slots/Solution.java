class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for( int i = 0 ;  i < flowers.length ; i++ ){
            int cur = flowers[i];
            Integer next =  set.higher(cur);
            if( next != null && next - cur == k + 1) return i + 1;
            Integer pre = set.lower(cur);
            if( pre != null && cur - pre == k + 1 ) return i + 1;
            set.add(cur);
        }
        return -1;
    }
}
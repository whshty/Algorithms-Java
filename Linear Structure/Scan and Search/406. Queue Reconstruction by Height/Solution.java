class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        
        List<int[]> res = new ArrayList<>();
        for( int[] cur : people ){
            // add at position cur[1]
            res.add(cur[1],cur);
        }
        return res.toArray(new int[people.length][]);
    }
}
class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for( int i = 0 ; i < B.length ; i++ ){
            map.computeIfAbsent(B[i], a -> new ArrayList<>()).add(i);
        }
        int[] res = new int[A.length];
        for( int i = 0 ; i < A.length ; i++ ){
            res[i] = map.get(A[i]).remove(map.get(A[i]).size()-1);
        }
        return res;
    }
}
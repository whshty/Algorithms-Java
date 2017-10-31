class Solution {
    public int findLength(int[] A, int[] B) {
        int len1 = A.length, len2 = B.length;
        if ( len1 == 0 || len2 == 0) return 0;
        
        int res = 0;
        
        //<numeber in arrayr, indexs in array>
        Map<Integer,List<Integer>> map = new HashMap< >();
        List<Integer> list;
        for (int i = 0; i < len1; i++) {
            int cur = A[i];
            if (map.containsKey(cur)) {
                list = map.get(cur);
                list.add(i);
                map.put(cur, list);
            } else {
                list = new ArrayList<>();
                list.add(i);
                map.put(cur,list);
            }
        }
        
        for (int i = 0; i < len2; i++) {
            int cur = B[i];
            if(!map.containsKey(cur)) continue;
            else if ( res == 0 ) res = 1;            

            list = map.get(cur);
            for (int temp : list) {
                if ( len1 - temp < res) break;
                int count = 1, index1 = temp + 1;
                int index2 = i + 1;
                
                while( index1 < len1 && index2 < len2 ){
                    if( A[index1++] == B[index2++] ) count++;
                    else break;
                }
                
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
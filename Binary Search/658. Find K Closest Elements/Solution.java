class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = arr.length-1;
        while( start < end ) {
            int mid = (start + end) >>> 1;
            if(arr[mid] == x) {
                end = mid;
                break;
            }
            else if( arr[mid] > x) end = mid-1;
            else start = mid + 1;
        }

        start = end;
        end++;
        while( k > 0 ) {
            if( end >= arr.length || ( start >= 0 && x - arr[start] <= arr[end] - x) )  start--;
            else end++;
            k--;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = start + 1; i < end ; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}

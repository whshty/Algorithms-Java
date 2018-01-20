class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = binarySearch(arr,x);
        int end = start + 1 ;
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
    private int binarySearch(int[] arr , int target ){
        int start = 0, end = arr.length - 1;
        while( start < end ){
            int mid = ( start + end ) >>> 1;
            if( arr[mid] == target ) return mid;
            else if( arr[mid] > target ) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }
}

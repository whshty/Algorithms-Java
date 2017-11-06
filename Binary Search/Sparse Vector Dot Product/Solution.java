// Brute Force
class Solution {
    public int dotProduct(int[] a, int[] b) {
        int len = a.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += a[i] * b[i];
        }
        return res;
    }
}
//Sparse Vector
class Solution {
    public int dotProduct(List<int[]> listA, List<int[]> listB){
        int res = 0;

        int len1 = listA.size();
        int len2 = listB.size();

        int i = 0 , j = 0;
        while( i < len1 && j < len2 ){
            int[] indexA = listA.get(i);
            int[] indexB = listB.get(j);
            if(indexA[0] == indexB[0]){
                res +=  indexA[1] * indexB[1];
                i++;
                j++;
            }
            else if(indexA[0] > indexB[0]) j++;
            else  i++;
        }
        return res;
    }
}

//If input A is too long, Binary Search

import java.util.*;

class Solution {
    public static void main(String[] args) {
        List<Vector> listA = new ArrayList<>();
        List<Vector> listB = new ArrayList<>();

        listA.add(new Vector(1,1));
        listA.add(new Vector(100,2));
        listA.add(new Vector(200,2));
        listA.add(new Vector(300,2));
        listA.add(new Vector(500,2));
        listA.add(new Vector(600,2));
        listA.add(new Vector(700,2));


        listB.add(new Vector(300,2));
        listB.add(new Vector(700,5));

        Solution sol = new Solution();
        int res = sol.dotProduct(listA,listB);
        System.out.println(res);

    }

    public int dotProduct(List<Vector> listA, List<Vector> listB){
        int res = 0;

        int len1 = listA.size();
        int len2 = listB.size();

        int i = 0 , j = 0;
        while( i < len1 && j < len2 ){
            Vector curA = listA.get(i);
            Vector curB = listB.get(j);
            if(curA.index == curB.index){
                res +=  curA.value * curB.value;
                i++;
                j++;
            } else if( curA.index > curB.index){
                j++;
            } else{
                i = binarySearch(listA,curB.index,i,listA.size());
            }
        }
        return res;
    }
    public int binarySearch(List<Vector> listA, int target, int start , int end){
        while( start < end ){
            int mid = (start+ end ) >>> 1;
            int curIndex = listA.get(mid).index;
            if( target <= curIndex ){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}

class Vector{
    int index;
    int value;

    Vector( int i, int v){
        index = i;
        value = v;
    }
}